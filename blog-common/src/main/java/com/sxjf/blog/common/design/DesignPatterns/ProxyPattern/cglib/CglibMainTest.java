package com.sxjf.blog.common.design.DesignPatterns.ProxyPattern.cglib;


public class CglibMainTest {

    public static void main(String[] args) {
        //生成Cglib代理类
        Engineer engineerProxy = (Engineer)CglibProxy.getProxy(new Engineer());
        //调用相关方法
        engineerProxy.eat();
    }

}
