package com.sample;

import com.sample.order.OrderNumber;
import com.sample.order.OrderService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLockApplicationTests {
    @Autowired
    private OrderService orderService;


    @Test
    public void getOrderNumberTest() {
            for (int i=0;i<100;i++) {
                new Thread(()->{
                    orderService.getOrderNumber(Thread.currentThread());
                }).start();
            }
    }

    /**
     * 用Synchronized 方法锁住
     */
    @Test
    public void getSynchronizedTest() {
        for (int i=0;i<100;i++) {
            new Thread(()->{
                orderService.getSynchronized(Thread.currentThread());
            }).start();
        }
    }



}
