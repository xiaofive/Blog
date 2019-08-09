package com.sxjf.blog.common.design.DesignPatterns.AbstractFactoryPattern.colour;

public class Yellow implements Colour{
    @Override
    public void fill() {
        System.out.println("Inside Yellow::fill() method.");
    }
}
