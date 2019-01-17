package com.even.common.validation;

import com.even.common.exception.DescribeException;
import com.even.common.exception.eum.ExceptionEnum;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 * 断言工具类，不满足条件全部抛异常
 */
public class AssertUtil {
    /**
     * 判断字符串
     * @param string
     */
    public static void  hasText(String string){
        if(!StringUtils.hasText(string)){
            throw new DescribeException(ExceptionEnum.NULL_ERROR.getCode(),string+" 字符串不能为空");
        }
    }

    /**
     * 判断对象不为空
     * @param o
     * @param message
     */
    public static void NotNull(Object o,String message){
        if(o==null){
            throw new DescribeException(ExceptionEnum.NULL_ERROR.getCode(),message);
        }
    }

    /**
     * 判断boolean类型
     * @param b
     * @param message
     */
    public static void success(boolean b,String message){
        if(b==false){
            throw new DescribeException(ExceptionEnum.NULL_ERROR.getCode(),message);
        }
    }
}
