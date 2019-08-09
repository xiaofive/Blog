package com.sxjf.blog.common.design.SevenPrinciples.OpenClose;

/**
 * Created with IntelliJ IDEA.
 * Description: 课程接口：演示面向接口编程。
 * Author: wangyang
 * Date: 2019/6/26
 * Time: 13:39
 */
public interface ICourse {

    Integer getId();

    String getName();

    Double getPrice();

//    Double getDiscountPrice();//---->如若这样新增，则为不妥。我们接口是不应该经常变化的，它应该是稳定且可靠的，否则，接口作为契约的作用就失去了。违反了开闭原则。
                                                //我们提倡： 一个软件实体如类，模块，和函数应该对扩展开放，对修改关闭。

}
