package com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion;

public class PythonCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习Python课程");
    }
}
