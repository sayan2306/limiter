package com.limiter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("@annotation(com.limiter.annotation.TrackExecutionTime)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Method Name: " + proceedingJoinPoint.getSignature() + " took: " + (endTime - startTime));
        return obj;
    }
}
