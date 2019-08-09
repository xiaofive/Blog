package com.sxjf.blog.common.DesignPatterns.ProxyPattern.cglib;

/**
 * Created with IntelliJ IDEA.
 * Description: 需要代理的类
 * Author: wangyang
 * Date: 2019/6/18
 * Time: 13:21
 */
public class Engineer {

    //可以被代理
    public void eat(){
        System.out.println("工程师正在吃饭");
    }

    //final方法不会被生成的子类覆盖
    public final void work(){
        System.out.println("工程师正在工作");
    }

    //private方法不会被生成的子类覆盖
    public void play(){
        System.out.println("this engineer is playing game");
    }

}
