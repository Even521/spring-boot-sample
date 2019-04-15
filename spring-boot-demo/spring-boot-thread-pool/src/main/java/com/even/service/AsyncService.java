package com.even.service;

import java.util.List;

/**
 * @Author even
 * @Date 2019/4/1 17:39
 * @Describe
 */
public interface AsyncService {
    /**
     * 异步请求
     * @param list
     */
    void asyncRequest(List<Integer> list);

    /**
     * 打印
     */
    void printInLog();
}
