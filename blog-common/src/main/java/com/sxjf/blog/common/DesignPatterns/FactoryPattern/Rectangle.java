package com.sxjf.blog.common.DesignPatterns.FactoryPattern;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
