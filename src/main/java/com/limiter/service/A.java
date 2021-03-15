package com.limiter.service;


import com.limiter.annotation.RateLimit;
import com.limiter.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class A {
    public void foo() {
        System.out.println("This is the foo method inside class A");
    }

    @RateLimit
    public int bar(String t) throws Exception{
        Thread.sleep(5000);
        System.out.println("This is the bar method inside class A for thread " + t);
        return 1;
    }
}
