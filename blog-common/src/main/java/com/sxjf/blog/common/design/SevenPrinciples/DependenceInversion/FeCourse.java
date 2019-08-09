package com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion;

public class FeCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习FE课程");
    }
}
