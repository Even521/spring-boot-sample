package com.sample.order;

import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2018/12/6 0006.
 *
 * @author even
 * 订单工具类
 */
@Service
public class OrderNumber implements OrderService  {
    private int i=100;

    @Override
    public   String getOrderNumber(Thread thread){
        i--;
        String s=thread.getName()+"-"+thread.getId()+"-"+i;
        System.out.println(s);
        return s;
    }

    @Override
    public  synchronized String getSynchronized(Thread thread){
       return this.getOrderNumber(thread);
    }



}
