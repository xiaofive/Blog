package com.sxjf.blog.common.aspectJ.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 计算方法注解
 * Author: wangyang
 * Date: 2019/4/15
 * Time: 20:49
 */
@Target(ElementType.METHOD) //@Target注解是标注这个类它可以标注的位置,常用的元素类型(ElementType):
@Retention(RetentionPolicy.RUNTIME) //@Retention注解表示的是本注解(标注这个注解的注解保留时期)
@Documented //@Documented是否生成文档的标注, 也就是生成接口文档是, 是否生成注解文档
public @interface CalAnnotation {
    /**
     *
     */
    public String value() default "a";
}
