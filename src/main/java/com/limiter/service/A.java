package com.limiter.service;


import com.limiter.annotation.RateLimit;
import org.springframework.stereotype.Service;

@Service
public class A {
    public void foo() {
        System.out.println("This is the foo method inside class A");
    }

    @RateLimit
    public void bar() throws Exception{
        System.out.println("This is the bar method inside class A");
    }
}
