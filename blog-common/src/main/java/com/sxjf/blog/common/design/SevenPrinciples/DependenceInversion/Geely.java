package com.sxjf.blog.common.design.SevenPrinciples.DependenceInversion;

/**
 * Created with IntelliJ IDEA.
 * Description: 底层模块 高层Test模块的实现依赖于底层模块Geely的具体实现。Test要实现什么，我们就需要来Geely中进行扩展补充。然后在高层模块才可以使用。 违反了依赖倒置原则。
 * Author: wangyang
 * Date: 2019/6/27
 * Time: 14:03
 */
public class Geely {//------------------>体会Geely不依赖于具体的课程。 没有import。 就算出了新的语言。Geely不需要动。ICourse也不需要动。新的语言实现ICourse就可扩展。有了依赖注入原则，对理解spring的依赖注入，控制反转就相当容易了。

    private ICourse course;

    //set注入
    public void setCourse(ICourse course) {
        this.course = course;
    }

    //构造器注入
    //    public Geely(ICourse course) {
//        this.course = course;
//    }

    public void studyCourse(){
        course.studyCourse();
    }

}
