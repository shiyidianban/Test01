package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoApplication {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5,21);
        System.out.println(atomicInteger.compareAndSet(5,19)+"  "+atomicInteger.get());
    }

}
