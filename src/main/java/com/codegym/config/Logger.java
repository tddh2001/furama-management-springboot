package com.codegym.config;

import com.codegym.model.Customer;
import com.codegym.model.Log;
import com.codegym.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class Logger {
    @Autowired
    LogService logService;

    @Around("execution(public * com.codegym.service.CustomerService.create(..))")
    public Customer logCreate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //chua xong
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = (Customer) proceedingJoinPoint.proceed();
        String nameUpdate = customer.getCustomerName();
        String iDUpdate = customer.getCustomerId();
        Date date = new Date();
        String name = proceedingJoinPoint.getSignature().getName();
        //chua xong
        Log log = new Log(name, date, nameUpdate, iDUpdate, ((UserDetails)obj).getUsername());
        logService.save(log);
        return customer;
    }

    @Around("execution(public * com.codegym.service.CustomerService.edit(..))")
    public Customer logEdit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = (Customer) proceedingJoinPoint.proceed();
        String nameUpdate = customer.getCustomerName();
        String idUpdate = customer.getCustomerId();
        Date date = new Date();
        String name = proceedingJoinPoint.getSignature().getName();
        Log log = new Log(name, date, nameUpdate, idUpdate, ((UserDetails)obj).getUsername());
        logService.save(log);
        return customer;
    }

    @Around("execution(public * com.codegym.service.CustomerService.remove(..))")
    public Customer logRemove(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = (Customer) proceedingJoinPoint.proceed();
        String nameUpdate = customer.getCustomerName();
        String idUpdate = customer.getCustomerId();

        Date date = new Date();
        String name = proceedingJoinPoint.getSignature().getName();
        Log log = new Log(name, date, nameUpdate, idUpdate, ((UserDetails)obj).getUsername());
        logService.save(log);
        return customer;
    }


}
