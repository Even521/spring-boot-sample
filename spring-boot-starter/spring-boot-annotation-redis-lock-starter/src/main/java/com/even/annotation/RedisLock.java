package com.even.annotation;

import java.lang.annotation.*;

/**
 * @author even
 * @date 2019/9/20 0020
 * @describe
 * redis锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    /**
     * 可使用SpEL传方法参数
     * @return
     */
    String value() default "";

    /**
     * redis锁的key值
     * @return
     */
    String lockKey() default "";
}
