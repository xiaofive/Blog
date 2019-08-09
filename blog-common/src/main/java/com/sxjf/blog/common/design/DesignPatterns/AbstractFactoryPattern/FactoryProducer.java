package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern;

import com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.colour.ColourFactory;
import com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.shape.ShapeFactory;

/**
 * Created with IntelliJ IDEA.
 * Description: 工厂创造器
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 14:25
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("COLOUR")){
            return new ColourFactory();
        }
        return null;
    }
}
