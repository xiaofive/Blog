package com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern;

import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.colour.Colour;
import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.shape.Shape;

/**
 * Created with IntelliJ IDEA.
 * Description: 为Colour和Shape对象创建抽象类来获取工厂
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 14:03
 */
public abstract class AbstractFactory {
    public abstract Colour getColour(String colour);
    public abstract Shape getShape(String shape);
}
