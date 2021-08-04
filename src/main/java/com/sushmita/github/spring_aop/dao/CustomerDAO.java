package com.sushmita.github.spring_aop.dao;

import org.springframework.stereotype.Component;

@Component(value = "customerDAO")
public class CustomerDAO {
    public void addAccount(){
        System.out.println("addacount()");
    }

    public void addAccount(int a){
        System.out.println("addacount(a)");
    }

    public void addAccount(int a, int b){
        System.out.println("addacount(a, b)");
    }

    public void addCustomer(){
        System.out.println("Adding customer");
    }

    public void deleteCustomer(){
        System.out.println("Delete Customer");
    }

    public void testException() throws Exception {
        throw new Exception("testing the exception");
    }
}
