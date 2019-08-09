package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.shape;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
