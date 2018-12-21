package com.sample;

import com.even.fastjson.DefaultRedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/12/12 0012.
 *
 * @author even
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLockApplicationTest {
    @Autowired
    private DefaultRedisLock defaultRedisLock;

    @Test
    public void  defaultRedisLockTest(){
        try {
            boolean success=defaultRedisLock.tryLock("hello",100);
            if (success){
                System.out.println("加锁成功");
            }
            System.out.println(success);
        }finally {
            defaultRedisLock.unlock("hello");
        }
    }




}
