package com.sample.mysql.lock.service;

import com.sample.mysql.lock.entity.TestLock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author even
 * @since 2018-12-07
 */
public interface ITestLockService extends IService<TestLock> {

    /**
     * 查询
     * @param outerSerialNo
     * @param custNo
     * @param source
     * @return
     */
    TestLock findOneTestLock(String outerSerialNo,String custNo,String source);

    /**
     * 加锁
     * @param outerSerialNo
     * @param custNo
     * @param source
     * @return
     */
    boolean lock(String outerSerialNo,String custNo,String source);

    /**
     * 解锁
     * @param outerSerialNo
     * @param custNo
     * @param source
     * @param targetStatus
     */
    void unLock(String outerSerialNo,String custNo,String source,String targetStatus);

}
