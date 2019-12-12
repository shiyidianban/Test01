package com.example.demo.test01.test;

import java.util.Scanner;

public class Test32 {
    static int cnt = 6;

    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }

    static {
        cnt /= 3;
    }
}