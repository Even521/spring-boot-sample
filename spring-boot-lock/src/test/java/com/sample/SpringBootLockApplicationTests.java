package com.sample;

import com.sample.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLockApplicationTests {
    @Autowired
    private OrderService orderService;
    private final static int start=0;
    private final static int end=100;


    @Test
    public void getOrderNumberTest() {
            for (int i=start;i<end;i++) {
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
        for (int i=start;i<end;i++) {
            new Thread(()->{
                orderService.getSynchronized(Thread.currentThread());
            }).start();
        }
    }



}
