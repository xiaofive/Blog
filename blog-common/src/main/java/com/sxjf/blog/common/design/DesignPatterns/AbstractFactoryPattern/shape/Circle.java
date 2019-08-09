package com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.shape;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
