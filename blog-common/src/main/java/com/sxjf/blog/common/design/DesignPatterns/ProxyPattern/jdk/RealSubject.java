package com.sxjf.blog.common.design.DesignPatterns.ProxyPattern.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description: 真实对象
 * Author: wangyang
 * Date: 2019/6/17
 * Time: 13:29
 */
public class RealSubject implements Subject{

    @Override
    public int sellBooks() {
        System.out.println("卖书");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "王瑶";
    }
}
