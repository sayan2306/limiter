package com.limiter.service;


import com.limiter.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class A {

    public void foo() {
        System.out.println("This is the foo method inside class A");
    }

    @TrackExecutionTime
    public void bar() throws Exception{
        Thread.sleep(1000);
        System.out.println("This is the bar method inside class A");
    }
}
