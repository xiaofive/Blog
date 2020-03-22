package com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion;

public class Test {

//    public static void main(String[] args) {
//        //v2:接口方法注入
////        Geely geely = new Geely();
////        geely.studyCourse(new JavaCourse());
////        geely.studyCourse(new FeCourse());
////        geely.studyCourse(new PythonCourse());
//
//        //v3：构造器注入
////        Geely geely = new Geely(new JavaCourse());这样在学习还需要再new一个geely对象出来。
////        geely.studyCourse();
//
//        //v4:set注入
//        try{
//            Class<?> c = Class.forName("com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion.Geely");
//            Geely geely = (Geely) c.newInstance();
//            geely.setCourse(new JavaCourse());
//            geely.studyCourse();
//            geely.setCourse(new FeCourse());
//            geely.studyCourse();
//            geely.setCourse(new PythonCourse());
//            geely.studyCourse();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

}
