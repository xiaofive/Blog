package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.colour;

public class Blue implements Colour{
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
