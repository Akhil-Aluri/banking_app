package com.aluri.accounts.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.aluri.accounts.service.AccountsService.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time Taken by - " + proceedingJoinPoint.getSignature().getName() + " : " + (end - start) + "ms");
        return obj;
    }
}
