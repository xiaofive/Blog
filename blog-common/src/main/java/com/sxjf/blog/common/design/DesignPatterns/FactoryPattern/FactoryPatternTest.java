package com.sxjf.blog.common.design.DesignPatterns.FactoryPattern;
/**
 * Created with IntelliJ IDEA.
 * Description: 工厂模式测试类
 *
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * url详解：http://www.runoob.com/design-pattern/factory-pattern.html
 *
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 11:26
 */
public class FactoryPatternTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("Circle");
        shape3.draw();
    }
}
