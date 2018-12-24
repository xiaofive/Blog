package com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.shape;

import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.AbstractFactory;
import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.colour.Colour;
/**
 * Created with IntelliJ IDEA.
 * Description: shape工厂
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 14:17
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if (shape == null){
            return null;
        }
        if (shape.equals("Circle")){
            return new Circle();
        }if (shape.equals("Rectangle")){
            return new Rectangle();
        }if (shape.equals("Square")){
            return new Square();
        }
        return null;
    }

    @Override
    public Colour getColour(String colour) {
        return null;
    }
}
