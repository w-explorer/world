package com.learn.world.spring.aspect.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wencheng
 * @create 2021/9/18 0:07
 */
@Aspect
@Component
public class ApiCountAspectConfig {

    @Pointcut("@annotation(com.learn.world.spring.aspect.handler.ApiCount)")
    private void pointcut(){}

    @Before(value ="pointcut()" )
    public void before(){
        System.out.println("前置方法---我在最前面");
    }

    @Around(value = "pointcut() && @annotation(apiCount)")
    public Object otherAround(ProceedingJoinPoint joinPoint, ApiCount apiCount){
        System.out.println("进入方法之前---环绕通知");
        try {
            joinPoint.proceed();
            System.out.println("推出方法后---环绕通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("推出方法后---报错记录");
        }
        return null;
    }

    @After(value ="pointcut()" )
    public void after(){
        System.out.println("后置方法---我在最后面");
    }


}
