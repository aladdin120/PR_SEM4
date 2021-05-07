package com.example.lab21.logs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Around("allServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Class Name: "+ joinPoint.getSignature().getDeclaringTypeName() +". Method Name: "+
                joinPoint.getSignature().getName() + ". Time taken for Execution is: " + (end-start) +"ms");
        return object;
    }

    @Pointcut("within(com.example.lab21.service.*)")
    public void allServiceMethods() {}
}
