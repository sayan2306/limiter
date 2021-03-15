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
        Thread t1 = new Thread() {
            public void run(){
                try {
                    System.out.println("SOUT " + a.bar("t1"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();


        Thread t2 = new Thread() {
            public void run(){
                try {
                    System.out.println("SOUT " + a.bar("t2"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t2.start();


        Thread t3 = new Thread() {
            public void run(){
                try {
                    System.out.println("SOUT " + a.bar("t3"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t3.start();


        Thread t4 = new Thread() {
            public void run(){
                try {
                    System.out.println("SOUT " + a.bar("t4"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t4.start();
    }

}