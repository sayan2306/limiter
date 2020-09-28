package com.limiter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Aspect
@Component
public class TrackExecutionTimeAspect {
    static HashMap<String, Long> hm = new HashMap<String, Long>();


    @Around("@annotation(com.limiter.annotation.TrackExecutionTime)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("The method took " + (endTime - startTime) + " ms");
//        Object obj = null;
//        String key = proceedingJoinPoint.getSignature().toString();
//        System.out.println("Contains: " + key);
//        if(hm.containsKey(key)) {
//            if(System.currentTimeMillis() - hm.get(key) > 5000) {
//                obj = proceedingJoinPoint.proceed();
//                hm.put(key, System.currentTimeMillis());
//            } else {
//                System.out.println("Too many requests!");
//                return obj;
//            }
//        } else {
//            obj = proceedingJoinPoint.proceed();
//            hm.put(key, System.currentTimeMillis());
//        }
        return obj;
    }
}
