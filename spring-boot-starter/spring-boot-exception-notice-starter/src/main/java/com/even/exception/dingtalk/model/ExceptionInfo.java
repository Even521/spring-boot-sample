package com.even.exception.dingtalk.model;

import lombok.Data;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 * 异常信息模型
 */
@Data
public class ExceptionInfo {
    /**
     * 工程名
     */
    private String project;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 异常的标识码
     */
    private String uid;
    /**
     * 请求地址
     */
    private String reqAddress;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 方法参数信息
     */
    private Object params;
    /**
     * 类路径
     */
    private String classPath;
    /**
     * 异常追踪信息
     */
    private String exceptionMessage;
    /**
     * 异常追踪信息
     */
    private List<String> traceInfo=new ArrayList<>();
    /**
     * 最后一次出现的时间
     */
    private LocalDateTime latestShowTime=LocalDateTime.now();

    /**
     * 生成异常标识码
     * @return
     */
    private String calUid(){
        return DigestUtils.md5DigestAsHex(
                String.format("%s-%s",exceptionMessage,traceInfo.size()>0?traceInfo.get(0) : "").getBytes());
    }

    /**
     * 获取异常消息格式化
     * @param throwable
     * @return
     */
    private String getExceptionMessage(Throwable throwable){
        String ex=throwable.toString();
        if (throwable.getCause()!=null){
            ex=String.format("%s\r\n\tcaused by : %s",ex,getExceptionMessage(throwable.getCause()));
        }
        return ex;
    }

    /**
     * 异常信息构造方法
     * @param ex
     * @param methodName
     * @param filterTrace
     * @param args
     * @param reqAddress
     */
    public ExceptionInfo(Throwable ex, String methodName, String filterTrace, Object args, String reqAddress,String userId) {
        this.exceptionMessage = getExceptionMessage(ex);
        this.reqAddress = reqAddress;
        this.params = args;
        this.userId=userId;
        List<StackTraceElement> list = Arrays.stream(ex.getStackTrace())
                .filter(x -> filterTrace == null || x.getClassName().startsWith(filterTrace))
                .filter(x -> !"<generated>".equals(x.getFileName())).collect(Collectors.toList());
        if (list.size() > 0) {
            this.traceInfo = list.stream().map(StackTraceElement::toString).collect(Collectors.toList());
            this.methodName = null == methodName ? list.get(0).getMethodName() : methodName;
            this.classPath = list.get(0).getClassName();
        }
        this.uid = calUid();
    }


    /**
     * 创建消息模板
     * @return
     */
    public String createText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("项目名称：").append(project).append("\n");
        stringBuilder.append("请求用户ID：").append(userId).append("\n");
        stringBuilder.append("类路径：").append(classPath).append("\n");
        stringBuilder.append("请求地址：").append(reqAddress).append("\n");
        stringBuilder.append("方法名：").append(methodName).append("\n");
        if (params != null) {
            stringBuilder.append("方法参数：").append(params).append("\n");
        }
        stringBuilder.append("异常信息：").append("\n").append(exceptionMessage).append("\n");
        stringBuilder.append("异常追踪：").append("\n").append(String.join("\n", traceInfo)).append("\n");
        stringBuilder.append("最后一次出现时间：")
                .append(latestShowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return stringBuilder.toString();
    }
}
