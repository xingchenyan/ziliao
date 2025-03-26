package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * AOP 在不改变原有业务逻辑的情况下增强横切逻辑
 * 横切逻辑代码使用场景有限：权限校验代码、日志代码、事务控制代码、性能监控代码
 *
 * JoinPoint(连接点)：方法开始时、方法结束时、正常运行完毕时、异常时等这些时机点，称之为连接点，连接点是一种候选点
 * Pointcut(切入点): 指定AOP思想想要影响的具体方法是哪些
 * Advice(通知、增强): 指的是横切逻辑、方位点
 * Target（目标对象）: 代理的目标对象，被代理对象
 * Proxy(代理)：指一个类被AOP织入增强后，产生的代理类。即代理对象
 * Weaving(织入)：指把增强应用到目标对象来创建新的代理对象的过程，spring采用动态代理织入
 * Aspect(切面)：对上述概念的一个综合
 *  切面=切点+增强
 *      = 切入点（锁定方法） + 方位点（锁定时机） + 横切逻辑
 * 目的就是为了锁定要在哪个地方插入什么横切逻辑代码
 *
 *  JDK动态代理要求被代理对象实现了接口 CGLIB没有强制要求要求，因此对象实现未实现接口时都可以使用使用cglib，使用jdk必须实现接口
 */
// 指定此为一个横切逻辑类
@Aspect
@Component
// 开启aop
@EnableAspectJAutoProxy
public class AopCode {
    //指定切入点
    @Pointcut("execution(* com.example.aop.Animal.*(..))")
    public void pt1(){

    }

    @Before("pt1()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("业务逻辑执行前。。。。。");
    }

    @After("pt1()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("业务逻辑执行后。。。。。");
    }

    @AfterThrowing("pt1()")
    public void exceptionMethod(JoinPoint joinPoint){
        System.out.println("业务逻辑报错后。。。。。");
    }

    @AfterReturning(value = "pt1()",returning = "retVal")
    public void successMethod(Object retVal){
        System.out.println("业务逻辑返回后。。。。。");
    }

//    @Around("pt1()")
    public void aroundMethod(JoinPoint joinPoint){
        System.out.println("环绕通知。。。。。");
    }
}
