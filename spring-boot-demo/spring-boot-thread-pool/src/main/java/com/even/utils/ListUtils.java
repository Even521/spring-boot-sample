package com.even.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author even
 * @Date 2019/4/1 13:56
 * @Describe
 */
public class ListUtils {

    /**
     * List分段法
     * @param source
     * @param n 分段个数
     * @param <T>
     * @return
     */
    public static  <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<>();
        //(先计算出余数)
        int remainder = source.size() % n;
        //然后是商
        int number = source.size() / n;
        //偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }
}
