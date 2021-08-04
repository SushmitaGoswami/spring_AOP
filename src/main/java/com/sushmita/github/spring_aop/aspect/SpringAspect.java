package com.sushmita.github.spring_aop.aspect;

import com.sushmita.github.spring_aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class SpringAspect {
    // for any package and any class

    @Before("execution(public void addAccount())")
    public void beforeAdvice(){
        System.out.println("Advice : execution(public void addAccount())!");
    }


    // for any class of com.sushmita.github.spring_aop package
    @Before("execution(public void com.sushmita.github.spring_aop.dao.*.addAccount())")
    public void beforeAdvice1(){
        System.out.println("Advice : execution(public void com.sushmita.github.spring_aop.dao.*.addAccount())");
    }


    // for any package and any class with addAccount receives one argument
    @Before("execution(* addAccount(*))")
    public void beforeAdvice2(){
        System.out.println("Advice : execution(* addAccount(*))");
    }


    // for any package and any class with addAccount receives 0 or more arguments
    @Before("execution(* addAccount(..))")
    public void beforeAdvice3(){
        System.out.println("Advice : execution(* addAccount(..))");
    }


    // for any package and any class with method starts with add method and return type is void
    @Before("execution(void add*())")
    public void beforeAdvice4(){
        System.out.println("Advice : execution(void add*())");
    }


    // for any package and any class with method starts with add method and return type is anything.
    @Before("execution(public * add*())")
    public void beforeAdvice5(){
        System.out.println("Advice : execution(public * add*())");
    }


    // for any class of com.sushmita.github.spring_aop package
    @Before("execution(public void com.sushmita.github.spring_aop.dao.AccountDAO.addAccount())")
    public void beforeAdvice6(){
        System.out.println("Advice : execution(public void com.sushmita.github.spring_aop.dao.AccountDAO.addAccount())");
    }



    @AfterThrowing(pointcut = "execution(* com.sushmita.github.spring_aop.dao.*.*(..))",
            throwing = "exec")
    public void afterThrowingException(JoinPoint joinPoint, Throwable exec){
        System.out.println("Method signature: " + joinPoint.getSignature());
        System.out.println("Handling exception: "+ exec.getMessage());
    }


    @AfterReturning(pointcut = "execution(* find*())",
            returning = "result")
    public void afterReturningAnalytics(JoinPoint joinPoint, List<Account> result){
        System.out.println(joinPoint.getSignature());

        convertUpperCase(result);

        System.out.println("After uppercase conversion...");
        System.out.println(result);
    }

    private void convertUpperCase(List<Account> result){
        for(Account account:result){
            account.setName(account.getName().toUpperCase());
        }
    }


    @After("execution(* com.sushmita.github.spring_aop.dao.*.*(..))")
    private void afterfinallyAdvice(JoinPoint joinPoint){
        System.out.println("after advice!");
        System.out.println("Method signature " + joinPoint.getSignature());
    }


    @Around("execution(* com.sushmita.github.spring_aop.dao.*.find*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before find");
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Exception occurred " + throwable.getMessage());
            throw throwable;
        }
        System.out.println("after find");
        return proceed;
    }
}
