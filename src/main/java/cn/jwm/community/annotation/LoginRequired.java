package cn.jwm.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//作用在方法上
@Retention(RetentionPolicy.RUNTIME)//运行时有效
//
public @interface LoginRequired {
    //不用写内容，只是个标记，如果方法上有这个注解就拦截。
}
