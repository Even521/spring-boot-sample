package com.sample.order;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;


/**
 * Created by Administrator on 2018/12/6 0006.
 *
 * @author even
 * 订单工具类
 */
@Service
public class OrderNumber implements OrderService  {
    private int i=0;

    /**
     *  生成订单号伪代码
     */
    @Override
    public   String getOrderNumber(Thread thread){
        //每生成一次累加一次
        i++;
        String s=thread.getName()+"-"+thread.getId()+"-"+i;
        System.out.println(s);
        return s;
    }

    @Override
    public  synchronized String getSynchronized(Thread thread){
       return this.getOrderNumber(thread);
    }



}
