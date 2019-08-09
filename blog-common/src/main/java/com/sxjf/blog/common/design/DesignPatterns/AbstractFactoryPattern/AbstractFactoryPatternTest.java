package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern;

import com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.colour.Colour;
import com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.shape.Shape;

/**
 * Created with IntelliJ IDEA.
 * Description: 抽象工厂测试类
 *
 *  抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 *  这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 * 详情url：http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 *
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 14:36
 */
public class AbstractFactoryPatternTest {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为Circle的对象
        Shape shape1 = shapeFactory.getShape("Circle");
        //调用Circle的draw方法
        shape1.draw();
        //获取形状为Rectangle的对象
        Shape shape2 = shapeFactory.getShape("Rectangle");
        //调用Rectangle的draw方法
        shape2.draw();
        //获取形状为Square的对象
        Shape shape3 = shapeFactory.getShape("Square");
        //调用Square的draw方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colourFactory = FactoryProducer.getFactory("COLOUR");
        //获取Blue对象
        Colour colour = colourFactory.getColour("Blue");
        //调用blue的fill方法
        colour.fill();
        //获取Red对象
        Colour colour1 = colourFactory.getColour("Red");
        //调用Red的fill方法
        colour1.fill();
        //获取Yellow对象
        Colour colour2 = colourFactory.getColour("Yellow");
        //调用Yellow的fill方法
        colour2.fill();

    }
}
