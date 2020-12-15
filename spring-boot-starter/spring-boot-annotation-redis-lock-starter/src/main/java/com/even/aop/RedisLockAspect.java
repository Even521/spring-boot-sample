package com.even.aop;

import com.even.annotation.RedisLock;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author even
 * @date 2019/9/23 0023
 * @describe
 */
@Aspect
@Component
@Log4j2
public class RedisLockAspect {
    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @Around(value = "@annotation(redisLock)")
    public Object redisLock(ProceedingJoinPoint proceedingJoinPoint, RedisLock redisLock){
        Object output=null;
        try {
            MethodSignature signature= (MethodSignature) proceedingJoinPoint.getSignature();
            Method method=signature.getMethod();
            Object[] arguments=proceedingJoinPoint.getArgs();
            Object lockKey=parseSpEl(redisLock.lockKey(),method,arguments);
            Lock lock=redisLockRegistry.obtain(lockKey);
            try {
                boolean ifLock=lock.tryLock(3, TimeUnit.SECONDS);
                if (ifLock){
                    output=proceedingJoinPoint.proceed();
                }
                else {
                    arguments[1]="当前任务正在执行,请勿重复请求" ;
                    output=proceedingJoinPoint.proceed(arguments);
                    log.info("线程[{}]未获得锁,目前锁详情信息: {}",Thread.currentThread().getName(), lock);
                }
            }catch (Exception e){
                log.error("执行锁出错:{}",e.getMessage());
            }
            finally {
                lock.unlock();
            }
        }catch (Throwable e){
            log.error("aop redis distributed lock error:{}", e.getLocalizedMessage());
        }
        return output;
    }
    /**
     * 解析SpEL表达式
     * @param key SpEL表达式
     * @param method 反射得到的方法
     * @param args 反射得到的方法参数
     * @return 解析后SpEL表达式对应的值
     */
    public static Object parseSpEl(String key,Method method,Object[] args){
        ExpressionParser parser=new SpelExpressionParser();
        LocalVariableTableParameterNameDiscoverer localVariableTableParameterNameDiscoverer=new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = localVariableTableParameterNameDiscoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        if(args.length==parameterNames.length){
            for (int i = 0; i < args.length; i++) {
                context.setVariable(parameterNames[i],args[i]);
            }
        }
        return parser.parseExpression(key).getValue(context);
    }
}
