package com.sxjf.blog.common.design.DesignPatterns.FactoryPattern;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
