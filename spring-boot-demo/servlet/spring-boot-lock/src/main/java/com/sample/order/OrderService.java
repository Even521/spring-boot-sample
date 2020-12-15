package com.sample.order;

/**
 * Created by Administrator on 2018/12/6 0006.
 *
 * @author even
 */
public interface OrderService {
    /**
     * 获取一个订单号
     * @param thread
     * @return
     */
    String getOrderNumber(Thread thread);

    /**
     * 用Synchronized锁住
     * @param thread
     * @return
     */
    String getSynchronized(Thread thread);

}
