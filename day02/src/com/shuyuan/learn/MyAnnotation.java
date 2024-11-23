package com.shuyuan.learn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//自定义注解
//Retention注解的RetentionPolicy.RUNTIME表示该注解在运行时可以被JVM读取
//使用反射时要设置为Retention.RUNTIME（默认是RetentionPolicy.CLASS）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "Jack";
    int age() default 25;
}
