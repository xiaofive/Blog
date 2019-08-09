package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.shape;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
