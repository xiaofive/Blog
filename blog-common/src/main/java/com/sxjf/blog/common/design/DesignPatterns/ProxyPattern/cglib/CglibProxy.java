package com.sxjf.blog.common.design.DesignPatterns.ProxyPattern.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: CGLIB 代理类
 * Author: wangyang
 * Date: 2019/6/18
 * Time: 13:31
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
        System.out.println("### before invocation");
        Object result = method.invoke(target,objects);
        System.out.println("### end invocation");
        return result;
    }

    public static Object getProxy(Object target){
        Enhancer enhancer = new Enhancer();
        //设置需要代理的对象
        enhancer.setSuperclass(target.getClass());
        //设置代理人
        enhancer.setCallback(new CglibProxy(target));
        return enhancer.create();
    }

}
