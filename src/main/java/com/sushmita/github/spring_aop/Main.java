package com.sushmita.github.spring_aop;

import com.sushmita.github.spring_aop.configuration.SpringAOPConfigurations;
import com.sushmita.github.spring_aop.dao.AccountDAO;
import com.sushmita.github.spring_aop.dao.CustomerDAO;
import com.sushmita.github.spring_aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(SpringAOPConfigurations.class);

        AccountDAO accountDAO = configApplicationContext.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        accountDAO.addAccount(1);
        accountDAO.addAccount(1,2);
        accountDAO.addTest();
        accountDAO.withdrawAccount();
        accountDAO.addAccount(new Account("test", "Platinum"));
        List<Account> accountList = accountDAO.findAccounts();
        System.out.println("Accounts : " + accountList);

        CustomerDAO customerDAO = configApplicationContext.getBean("customerDAO", CustomerDAO.class);
        customerDAO.addAccount();
        customerDAO.addAccount(1);
        customerDAO.addAccount(1,2);
        customerDAO.addCustomer();
        customerDAO.deleteCustomer();
        try {
            customerDAO.testException();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        configApplicationContext.close();

    }
}
