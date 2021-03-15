package com.limiter.aspect;

import com.limiter.annotation.RateLimit;
import com.limiter.strategies.LeakyBucketRateLimitingStrategy;
import com.limiter.strategies.RateLimitingStrategy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Aspect
@Component
public class RateLimiterAspect {
    RateLimitingStrategy strategy = new LeakyBucketRateLimitingStrategy(1000);

    @Pointcut("@annotation(rateLimit)")
    public void callAt(RateLimit rateLimit) {
    }

    @Around("callAt(rateLimit)")
    public int interceptor(ProceedingJoinPoint proceedingJoinPoint, RateLimit rateLimit) throws Throwable {
        Object obj = null;
        String key = proceedingJoinPoint.getSignature().toString();
        if(strategy.allow(key)) {
            proceedingJoinPoint.proceed();
            return 1;
        } else {
            System.out.println("Too many requests!");

        }
        return 0;
    }
}
