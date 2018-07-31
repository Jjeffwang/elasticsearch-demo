package com.elasticsearch.aop;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/7/23 0023 下午 3:38
 * Description:自定义日志注解类
 */
@Documented()
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLog {
    String value() default "logger";
}
