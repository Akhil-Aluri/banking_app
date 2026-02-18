package com.aluri.accounts.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    //returntype, classname, methodname, args
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.aluri.accounts.service.AccountsService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.aluri.accounts.service.AccountsService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method Executed: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.aluri.accounts.service.AccountsService.*(..))")
    public void logMethodCrash(JoinPoint joinPoint){
        LOGGER.info("Method has some issues " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.aluri.accounts.service.AccountsService.*(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint){
        LOGGER.info("Method Executed Successfully" + joinPoint.getSignature().getName());
    }
}
