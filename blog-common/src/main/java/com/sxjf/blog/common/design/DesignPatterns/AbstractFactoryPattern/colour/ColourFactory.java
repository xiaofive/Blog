package com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.colour;

import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.AbstractFactory;
import com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.shape.Shape;

/**
 * Created with IntelliJ IDEA.
 * Description: colour工厂
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 14:20
 */
public class ColourFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Colour getColour(String colour) {
        if (colour == null){
            return null;
        }if (colour.equals("Blue")){
            return new Blue();
        }if (colour.equals("Red")){
            return new Red();
        }if (colour.equals("Yellow")){
            return new Yellow();
        }
        return null;
    }
}
