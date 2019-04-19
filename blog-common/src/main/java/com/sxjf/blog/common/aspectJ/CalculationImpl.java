package com.sxjf.blog.common.aspectJ;

import com.sxjf.blog.common.aspectJ.annotation.CalAnnotation;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: 假设我们需要在进行计算前后分别输出一句话，
 * 传统的方法我们用一实现类实现该计算接口，进行计算前后直接输出。
 * 但是确实存在很大的缺陷。
 *          如果存在大量的相关方法，我们则会每个方法里增加几行，会导致大量重复性代码，降低代码的美观。
 *          改进：有没有一种解决方案能让我们将这种重复性的代码只写一次，然后哪些方法需要用到，我们给个
 *          标记就行了呢。
 *          aop思想则很好的帮我们解决了这个问题，即面向切面编程。
 *          本来spring就自带一套aop实现，我们直接使用此实现即可，但是还需要定义一些xml文件。
 *          但由于我们使用的是spring-boot框架，这一步就省略掉了。也就是说，在spring-boot中，我们可以直接使用aop而不需要任何的配置。
 * Author: wangyang
 * Date: 2019/4/15
 * Time: 19:15
 */
@Component
public class CalculationImpl implements Calculation{

    @Override
    @CalAnnotation("加法运算")
    public int add(int a, int b) {
        int result = a + b;
        if (result < 100){
            throw new IllegalArgumentException("运算中抛出的异常");
        }
        return result;
    }

    @Override
    @CalAnnotation("减法运算")
    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    @Override
    @CalAnnotation("乘法运算")
    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    @Override
    @CalAnnotation("除法运算")
    public int div(int a, int b) {
        int result = a / b;
        return result;
    }

}
