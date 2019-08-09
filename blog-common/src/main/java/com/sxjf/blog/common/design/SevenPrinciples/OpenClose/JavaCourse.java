package com.sxjf.blog.common.design.SevenPrinciples.OpenClose;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: wangyang
 * Date: 2019/6/26
 * Time: 13:41
 */
public class JavaCourse implements ICourse{

    private Integer Id;
    private String name;
    private Double price;

    public JavaCourse(Integer id, String name, Double price) {
        this.Id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;  //直接这里修改返回 this.price*0.8 也不妥。如果除了商品打折，还有优惠券等活动折扣，到底返回哪个呢，不够用。
    }
}
