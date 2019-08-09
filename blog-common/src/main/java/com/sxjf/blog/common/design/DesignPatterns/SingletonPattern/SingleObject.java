package com.sxjf.blog.common.DesignPatterns.SingletonPattern;
/**
 * Created with IntelliJ IDEA.
 * Description: 单例模式
 * Author: wangyang
 * Date: 2019/3/1
 * Time: 9:47
 */
public class SingleObject {

    //创建SingleObject 的一个对象
    private static SingleObject singleObject = new SingleObject();

    //让构造函数为私有，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象

    public static SingleObject getSingleObject(){
        return singleObject;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }


































































































}
