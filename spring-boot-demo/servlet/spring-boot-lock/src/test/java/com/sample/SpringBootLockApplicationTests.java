package com.sample;

import com.sample.mysql.lock.mapper.TestLockMapper;
import com.sample.mysql.lock.service.ITestLockService;
import com.sample.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLockApplicationTests {
    private final static int START=0;
    private final static int END=100;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ITestLockService iTestLockService;




    /**
     * 测试没有加锁引起的线程安全问题
     */
    @Test
    public void getOrderNumberTest() {
            for (int i=START;i< END;i++) {
                new Thread(()-> {
                    orderService.getOrderNumber(Thread.currentThread());
                }).start();
            }
    }

    /**
     *
     * 用Synchronized 保证线程安全，缺点:如果是微服务集群的方式就不能保证数据唯一
     */
    @Test
    public void getSynchronizedTest() {
        for (int i=START;i< END;i++) {
            new Thread(()->{
                orderService.getSynchronized(Thread.currentThread());
            }).start();
        }
    }

    @Test
    public void mysqlLockTest(){
        //iTestLockService.lock("1","2","com.sample.mysql.lock.service.impl.lock()");
        for (int i=START;i< END;i++) {
                iTestLockService.lock("1","2","com.sample.mysql.lock.service.impl.lock()");
        }


     /*   new Thread(()->{
            iTestLockService.lock("1","2","com.sample.mysql.lock.service.impl.lock()");
        }).start();*/

    }



}
