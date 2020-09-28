package com.limiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.limiter.service.A;

@SpringBootApplication
public class Main implements CommandLineRunner {


    public static void main(String[] args) throws Exception{
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private A a;
    public void run(String... args) throws Exception {
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        Thread.sleep(1000);
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
        a.bar();
    }

}