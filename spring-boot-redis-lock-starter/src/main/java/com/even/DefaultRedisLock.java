package com.even.fastjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/12/12 0012.
 *
 * @author even
 */
@Component
public class DefaultRedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisLockProperty redisLockProperty;

    private static final ConcurrentHashMap<Long, String> threadKeyMap = new ConcurrentHashMap<>();

    public DefaultRedisLock(StringRedisTemplate redisTemplate, RedisLockProperty redisLockProperty) {
        this.redisTemplate = redisTemplate;
        this.redisLockProperty = redisLockProperty;
    }

    /**
     * 序列化
     * @param value
     * @return
     */
    public byte[] getSerializer(String value){
        return redisTemplate.getStringSerializer().serialize(value);
    }

    /**
     * 反序列
     * @param value
     * @return
     */
    public String getDeserialize(byte[] value){
       return redisTemplate.getStringSerializer().deserialize(value);
    }

    /**
     * redis 设置
     * @param key
     * @param value
     * @param timeout
     * @return
     */
    private boolean add(String key,String value,Long timeout){
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            boolean success = redisConnection.setNX(this.getSerializer(key), this.getSerializer(value));
            if (success) {
                redisConnection.pExpire(this.getSerializer(key), timeout);
            }
            return success;
        });
    }

    /**
     * 删除值
     * @param key
     * @param value
     * @return
     */
    private boolean del(String key,String value){
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection->{
            String val=getDeserialize(redisConnection.get(this.getSerializer(key)));
            if(!value.equals(val)) {
                return false;
            }
            redisConnection.del(redisConnection.get(this.getSerializer(key)));
            return true;
        });
    }

    /**
     * 获取锁的key
     * @param key
     * @return
     */
    private String getLockKey(String key) {
        return redisLockProperty.getPrefix() + key;
    }

    /**
     * 加锁，如果失败则抛出异常
     * @param key
     */
    public void lock(String key){
        key=this.getLockKey(key);
        long id=Thread.currentThread().getId();
        String uuid= UUID.randomUUID().toString();
        //如果当前线程ID存在抛出
        if(threadKeyMap.containsKey(id)){
            throw new RuntimeException("Current thread has acquired the lock");
        }
        try {
            threadKeyMap.put(id,uuid);
            boolean success=add(key,uuid,Long.parseLong(redisLockProperty.getTimeout()));
            if(!success){
                throw new RuntimeException(redisLockProperty.getDefaultError());
            }
        }catch (Exception e){
           threadKeyMap.remove(id);
           throw e;
        }
    }

    /**
     * 释放锁
     * @param key
     */
    public void unlock(String key){
        key=getLockKey(key);
        long id=Thread.currentThread().getId();
        if(!threadKeyMap.containsKey(id)){
            return;
        }
        try {
            String uuid=threadKeyMap.get(id);
            del(key,uuid);
        }finally {
            threadKeyMap.remove(id);
        }
    }

    /**
     * outtime为0
     * @param key
     * @return
     */
    public boolean tryLock(String key){
        return this.tryLock(key,0L);
    }

    /**
     * 尝试在固定时间内加锁，返回加锁结果，毫秒
     * @param key
     * @param time
     * @return
     */
    public boolean tryLock(String key,long time){
        key = getLockKey(key);
        String uuid = UUID.randomUUID().toString();
        long id = Thread.currentThread().getId();
        long timeout = Long.parseLong(redisLockProperty.getLiveTime());
        if (threadKeyMap.containsKey(id)) {
            return false;
        }
        try {
            threadKeyMap.put(id, uuid);
            boolean success = add(key, uuid, timeout);
            if (!success) {
                long max = timeout;
                long min = 50;
                if (time < min) {
                    if (time > 0) {
                        TimeUnit.MILLISECONDS.sleep(time);
                        success = add(key, uuid, timeout);
                    }
                } else {
                    max = Math.min(time, max);
                    while (max > 0) {
                        TimeUnit.MILLISECONDS.sleep(min);
                        success = add(key, uuid, timeout);
                        if (success) {
                            break;
                        }
                        max = max - min;
                        min = 2 * min;
                        min = Math.min(max, min);
                    }
                }
            }
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            threadKeyMap.remove(id);
            return false;
        }
    }
}
