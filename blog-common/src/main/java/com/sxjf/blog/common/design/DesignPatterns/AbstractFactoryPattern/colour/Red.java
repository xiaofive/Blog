package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.colour;

public class Red implements Colour{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
