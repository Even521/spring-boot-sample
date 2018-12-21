package com.even.fastjson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RedisLock {
    /**
     * redis key 的值
     *
     * @return
     */
    String value() default "";

    /**
     * 后缀
     *
     * @return 后缀
     */
    String suffix() default "";

    /**
     * 是否阻塞获取锁
     *
     * @return
     */
    boolean blocked() default false;
    /**
     * 抛出异常时，抛出的信息
     *
     * @return
     */
    String error() default "";

    /**
     * 阻塞获取锁的超时时间(单位毫秒)
     *
     * @return
     */
    long timeout() default 0L;
}
