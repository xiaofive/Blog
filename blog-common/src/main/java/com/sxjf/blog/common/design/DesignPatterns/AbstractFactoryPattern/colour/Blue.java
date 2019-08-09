package com.sxjf.blog.common.DesignPatterns.AbstractFactoryPattern.colour;

public class Blue implements Colour{
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
