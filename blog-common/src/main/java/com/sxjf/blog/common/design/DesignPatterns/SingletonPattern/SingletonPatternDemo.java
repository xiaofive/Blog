package com.sxjf.blog.common.DesignPatterns.SingletonPattern;
/**
 * Created with IntelliJ IDEA.
 * Description: 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 *  1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 * Author: wangyang
 * Date: 2019/3/1
 * Time: 9:54
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数SingleObject()是不可见的
        //SingleObject singleObject = new SingleObject();

        //获取唯一可用的对象
        SingleObject singleObject = SingleObject.getSingleObject();

        //显示消息
        singleObject.showMessage();

    }

}
