package com.sxjf.blog.common.design.SevenPrinciples.OpenClose;

/**
 * Created with IntelliJ IDEA.
 * Description: 开闭原则：用抽象构建框架，用实现扩展细节。
 * Author: wangyang
 * Date: 2019/6/26
 * Time: 21:51
 */
public class Test {

    public static void main(String[] args) {
        //ICourse javaCourse = new JavaCourse(1,"开闭原则",22d);
        //接口声明的对象      ->       子类的实例   （父类声明的引用，拿不到子类获取原价的方法。）
        ICourse iCourse = new JavaDiscountCourse(1,"开闭原则",22d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;//需要强转以下，就可以拿到子类获取原价的方法了。
        System.out.println("课程Id:"+javaCourse.getId()+"课程名称："+javaCourse.getName()+"课程原价："+javaCourse.getOriginPrice()+"$"+"课程折扣价："+javaCourse.getPrice()+"$");
    }

}
