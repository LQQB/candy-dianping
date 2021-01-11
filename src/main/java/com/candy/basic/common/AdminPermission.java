package com.candy.basic.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname 校验注解
 * @Description
 * @Author liqb
 * @Date 2021/1/7 0:03
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {

    String produceType() default "text/html";

}
