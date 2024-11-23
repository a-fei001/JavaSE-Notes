package EXERCISE.miniProject.mini26;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//注解的生命周期为运行时
@Target(ElementType.METHOD)//只能在方法上使用
public @interface MyJunit {

}
