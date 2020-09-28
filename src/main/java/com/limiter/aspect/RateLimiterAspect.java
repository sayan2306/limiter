package com.limiter.aspect;

import com.limiter.strategies.LeakyBucketRateLimitingStrategy;
import com.limiter.strategies.RateLimitingStrategy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Aspect
@Component
public class RateLimiterAspect {
    RateLimitingStrategy strategy = new LeakyBucketRateLimitingStrategy(1000);

    @Around("@annotation(com.limiter.annotation.RateLimit)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = null;
        String key = proceedingJoinPoint.getSignature().toString();
        if(strategy.allow(key)) {
            obj = proceedingJoinPoint.proceed();
        } else {
            System.out.println("Too many requests!");

        }
        return obj;
    }
}
