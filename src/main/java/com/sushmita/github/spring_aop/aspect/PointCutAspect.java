package com.sushmita.github.spring_aop.aspect;

import com.sushmita.github.spring_aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PointCutAspect {
    @Pointcut("execution(public * get*())")
    private void getter(){
    }

    @Pointcut("execution(public void set*(..))")
    private void setter(){
    }

    @Pointcut("execution(* com.sushmita.github.spring_aop.dao.*.*(..))")
    private void allMethodsOfClassesOfAPackage(){
    }

    @Order(0)
    @Before("allMethodsOfClassesOfAPackage() && !(getter() || setter())")
    public void performAPIAnalytics(JoinPoint joinPoint){
        System.out.println("Analytics is on...");
        System.out.println("Method Signature: " + joinPoint.getSignature());
        System.out.println("Method arguments: ");

        for(Object arg: joinPoint.getArgs()){
            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("Object: " + account);
            }
        }
    }


}
