package com.sxjf.blog.common.design.SevenPrinciples.OpenClose;

/**
 * Created with IntelliJ IDEA.
 * Description: 用子类继承来实现功能的扩展
 * 通过继承基类的方式，使我们对扩展是开放的，对修改基类，和接口是关闭的。变化的都是应用层的子模块。
 * 越低层，越基础的模块改动影响越大。（越低影响越大）
 * 则符合软件设计原则之：开闭原则
 * Author: wangyang
 * Date: 2019/6/26
 * Time: 22:03
 */
public class JavaDiscountCourse extends JavaCourse{

    //父类没有默认的构造器，则手动继承父类的已有构造器。
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    //子类新增原价就可以。
    public Double getOriginPrice(){
        return super.getPrice();
    }

    //通过重写父类的方法来实现对已有功能的扩展。---->但是原价没有了。
    @Override
    public Double getPrice() {
        return super.getPrice()*0.8;
    }
}
