package com.even.common.result;

import com.even.common.exception.eum.ExceptionEnum;
import lombok.NoArgsConstructor;

/**
 * 返回封装工具类
 */
@NoArgsConstructor
public class ResultUtils {
    /**
     * 空字符串
     */
    private static final String STR_EMPTY = "";
    /**
     * 请求成功CODE为1
     */
    private static final int SUCCESS_CODE=0;
    /**
     * 请求失败code为0
     */
    private static final int FAILURE_CODE=-1;
    /**
     * message
     */
    private static final String SUCCESS_MESSAGE="success";
    /**
     * 失败消息
     */
    private static final String FAILURE_MESSAGE="failure";

    private static Result resultBuilder(Object object,int code,String message){
        return Result.builder()
                .data(object)
                .status(code)
                .message(message).build();
    }

    /**
     * 请求成功，返回数据
     * @param object
     * @return
     */
    public static Result success(Object object){
        return resultBuilder(object,SUCCESS_CODE,SUCCESS_MESSAGE);
    }
    /**
     * 请求成功，返回数据
     * @param object
     * @return
     */
    public static Result success(Object object,String msg){
        return resultBuilder(object,SUCCESS_CODE,msg);
    }
    public static Result success(){
        return resultBuilder(null,SUCCESS_CODE,SUCCESS_MESSAGE);
    }

    /**
     * 请求失败
     * @param code
     * @param msg
     * @return
     */
    public  static Result error(int code,String msg){
        return resultBuilder(STR_EMPTY,code,msg);
    }
    /**
     * 请求失败
     * @param msg
     * @return
     */
    public  static Result error(String msg){
        return resultBuilder(STR_EMPTY,FAILURE_CODE,msg);
    }

    /**
     * 自定义错误枚举类
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum){
        return resultBuilder(STR_EMPTY,exceptionEnum.getCode(),exceptionEnum.getMsg());
    }


    /**
     * 操作
     * @param res
     * @param <T>
     * @return
     */
    public static  <T> Result<T> operation(int res) {
        return res>0?success():error(FAILURE_CODE,FAILURE_MESSAGE);
    }

    /**
     * 操作
     * @param res
     * @param <T>
     * @return
     */
    public static <T> Result<T>  operation(boolean res){
        return res==true?success():error(FAILURE_CODE,FAILURE_MESSAGE);
    }





}
