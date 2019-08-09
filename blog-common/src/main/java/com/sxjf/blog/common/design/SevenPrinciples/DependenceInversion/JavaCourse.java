package com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion;

public class JavaCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习Java课程");
    }
}
