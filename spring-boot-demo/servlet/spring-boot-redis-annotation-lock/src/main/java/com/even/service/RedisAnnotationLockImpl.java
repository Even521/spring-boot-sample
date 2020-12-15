package com.even.service;

import com.even.annotation.RedisLock;
import org.springframework.stereotype.Service;

/**
 * @author even
 * @date 2019/9/23 0023
 * @describe
 */
@Service
public class RedisAnnotationLockImpl implements RedisAnnotationLock {
    @RedisLock(value = "com:test")
    @Override
    public void test() {
        // 模拟方法执行耗时
        try {
            System.out.println("111111111111");
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
