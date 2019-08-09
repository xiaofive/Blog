package com.sxjf.blog.common.DesignPatterns.ProxyPattern.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: 定义一个处理器
 * Author: wangyang
 * Date: 2019/6/18
 * Time: 10:21
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
    *   因为需要处理真实角色，所以要把真实角色传进来。
    */
     Subject realSubject;

     public MyInvocationHandler(Subject realSubject){
         this.realSubject = realSubject;
     }

     public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
         System.out.println("调用代理类");
         if (method.getName().equals("sellBooks")){
             int invoke = (int)method.invoke(realSubject,args);
             System.out.println("调用的是卖书的方法");
             return invoke;
         }else {
             String string = (String)method.invoke(realSubject,args);
             System.out.println("调用的是说话的方法");
             return string;
         }
     }

}
