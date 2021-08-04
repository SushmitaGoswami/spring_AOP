package com.sushmita.github.spring_aop.dao;

import com.sushmita.github.spring_aop.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "accountDAO")
public class AccountDAO {
     public void addAccount(){
         System.out.println("addacount()");
     }

    public void addAccount(int a){
        System.out.println("addacount(a)");
    }

    public void addAccount(int a, int b){
        System.out.println("addacount(a, b)");
    }

    public void addAccount(Account account){
         System.out.println("Adding account.. " + account);
    }
    public void withdrawAccount(){
         System.out.println("withdraw account..");
    }

    public void addTest(){
         System.out.println("addTest");
    }

    public List<Account> findAccounts(){
         List<Account> accounts = new ArrayList<Account>();
         accounts.add(new Account("test", "test"));
         accounts.add(new Account("test1", "test1"));
         accounts.add(new Account("test2", "test2"));

         return accounts;
    }
}
