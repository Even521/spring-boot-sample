package com.sample;

import com.even.DefaultRedisLock;
import com.even.EnableRedisLock;
import com.even.annotation.RedisLock;
import com.even.annotation.RedisLockParam;
import com.even.annotation.RedisLockRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
