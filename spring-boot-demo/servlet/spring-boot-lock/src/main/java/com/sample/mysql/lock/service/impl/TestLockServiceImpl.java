package com.sample.mysql.lock.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sample.mysql.lock.entity.TestLock;
import com.sample.mysql.lock.mapper.TestLockMapper;
import com.sample.mysql.lock.service.ITestLockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2018-12-07
 */
@Service
public class TestLockServiceImpl extends ServiceImpl<TestLockMapper, TestLock> implements ITestLockService {

    @Override
    public TestLock findOneTestLock(String outerSerialNo, String custNo, String source) {
        TestLock testLock=this.baseMapper.selectOne(
                new QueryWrapper<TestLock>()
                        .lambda().eq(TestLock::getOuterSerialNo,outerSerialNo)
                        .eq(TestLock::getCustNo,custNo)
                        .eq(TestLock::getSourceCode,source)
        );
        return testLock;
    }

    @Override
    public boolean lock(String outerSerialNo, String custNo, String source) {
        TestLock testLock= findOneTestLock(outerSerialNo,custNo,source);
        System.out.println(JSON.toJSON(testLock));
        //这里判断当前资源是否被占用，如果为空那么可以插入一条
        if (testLock==null){
            System.out.println(Thread.currentThread().getId());
            boolean b=insert(outerSerialNo,custNo,source);
            return b;
        }
        if(testLock!=null&&testLock.getStatus().equals("Y")){
            System.out.println(Thread.currentThread().getId());
            boolean b=update(outerSerialNo,custNo,source,"P");
            return b;
        }
        return false;
    }

    private boolean update(String outerSerialNo, String custNo, String source,String status){
       return this.baseMapper.updateById(toBuildTestLock(outerSerialNo,custNo,source,status,Thread.currentThread().getId(),null))>0?true:false;
    }

    private boolean insert(String outerSerialNo, String custNo, String source){
       return   this.baseMapper.insert(toBuildTestLock(outerSerialNo,custNo,source,"P",Thread.currentThread().getId(),null))>0?true:false;
    }


    protected  static   TestLock toBuildTestLock(String outerSerialNo, String custNo, String source,String status,long threadNo,String remark){
        return TestLock.builder()
                .id(null)
                .outerSerialNo(outerSerialNo)
                .custNo(custNo)
                .sourceCode(source)
                .threadNo(threadNo)
                .status(status)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .remark(remark)
                .build();
    }

    @Override
    public void unLock(String outerSerialNo, String custNo, String source, String targetStatus) {
           update(outerSerialNo,custNo,source,"Y");
    }




}
