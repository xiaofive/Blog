package com.sxjf.blog.common.aspectJ;

import com.sxjf.blog.common.aspectJ.annotation.CalAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: 计算方法切面
 * Author: wangyang
 * Date: 2019/4/15
 * Time: 23:00
 */
@Aspect
@Component
//@Order(1)标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
public class CalAspect {

    /**
     * @Description: 定义一个切入点表达式, 用来确定哪些类需要代理
     * @Param: []
     * @return: void
     */
    @Pointcut(value = "@annotation(com.sxjf.blog.common.aspectJ.annotation.CalAnnotation)")
    public void calculationPointCut() {

    }

    /**
     * @Description: 前置通知, 在目标方法执行前执行
     * @Param: [joinPoint] 封装了代理方法信息的对象,若用不到则可以忽略不写
     * @return: void
     */
    @Before(value = "calculationPointCut()&&@annotation(d)")
    public void doBefore(JoinPoint joinPoint, CalAnnotation d) {
        System.out.println("------" + d.value() + "计算前------");//aop中获取自定义注解的值
        System.out.println(joinPoint);
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.out.println("------" + d.value() + "计算前------");
    }

    /**
     * @Description: 后置通知, 在目标方法执行后执行
     * @Param: [joinPoint]
     * @return: void
     */
    @After(value = "calculationPointCut()&&@annotation(d)")
    public void doAfter(JoinPoint joinPoint, CalAnnotation d) {
        System.out.println("------" + d.value() + "计算后------");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.out.println("------" + d.value() + "计算后------");
    }

    /**
     * 环绕通知,可自定义目标方法执行的时机
     *
     * @param pjd JoinPoint的子接口,添加了
     *            Object proceed() throws Throwable 执行目标方法
     *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *            两个方法
     * @return 此方法需要返回值, 返回值视为目标方法的返回值
     */
    @Around(value = "calculationPointCut()&&@annotation(d)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, CalAnnotation d) {
        Object result = null;
        try {
            System.out.println(d.value() + "环绕通知中的前置");
            System.out.println(proceedingJoinPoint);
            System.out.println(proceedingJoinPoint.getKind());
            System.out.println(proceedingJoinPoint.getSignature());
            System.out.println(proceedingJoinPoint.getSourceLocation());
            result = proceedingJoinPoint.proceed();  //执行目标方法
            System.out.println(d.value() + "环绕通知中的返回");
        } catch (Throwable e) {
            System.out.println(d.value() + "环绕通知中的异常");
        }
        System.out.println(d.value() + "环绕通知中的后置");
        return 3; //环绕通知此处返回值处理不好会报异常。返回值视为目标方法的返回值。
    }

    /**
     * @Description: 返回通知，在返回通知中，只需要在@AfterReturning注解中添加returning属性，就可以访问连接点的返回值，
     * 必须在通知方法的签名中添加一个同名参数，在运行时Spring AOP会通过这个参数传递给返回值。
     * 无论连接点正常返回还是抛出异常，后置通知都会执行。如果只想在连接点返回的时候记录日志，应使用返回通知代替后置通知。
     * @Param: [joinPoint, result]
     * @return: void
     */
    @AfterReturning(value = "calculationPointCut()&&@annotation(d)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result, CalAnnotation d) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + d.value() + " 的返回结果:" + result);
    }

    /**
     * @Description: 异常通知：只在连接点抛出异常时才执行异常通知
     * 将 throwing 属性添加到 @AfterThrowing 注解中, 也可以访问连接点抛出的异常. Throwable 是所有错误和异常类的超类. 所以在异常通知方法可以捕获到任何错误和异常.
     * 如果只对某种特殊的异常类型感兴趣, 可以将参数声明为其他异常的参数类型. 然后通知就只在抛出这个类型及其子类的异常时才被执行.
     * 在目标方法出现异常时会执行的代码.
     * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
     * @Param: []
     * @return: void
     */
    @AfterThrowing(value = "calculationPointCut()&&@annotation(d)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e, CalAnnotation d) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + d.value() + " 抛出的异常为:" + e);
    }

}
