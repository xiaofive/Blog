package com.sxjf.blog.common.Lambda;

public class IEatImpl implements IEat{
    @Override
    public Integer eat(String name, Integer num) {
        System.out.println("Hello Lambda!");
        return 0;
    }
}
