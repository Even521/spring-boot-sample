package com.even;

import com.even.service.RedisAnnotationLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisAnnotationLockApplicationTests {

    @Autowired
    private RedisAnnotationLock redisAnnotationLock;
    @Test
    public void contextLoads() {
        new Thread(()->{
            redisAnnotationLock.test();
            }).start();
    }

}
