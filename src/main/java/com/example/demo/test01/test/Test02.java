package com.example.demo.test01.test;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        short s1 = 1;
        //s1 = s1 + 1;
        s1 += 1;
        System.out.println(s1);
        byte a = 'a';
        switch (a) {
            case 'a':
                System.out.println("asd");
                break;

            default:
                System.out.println("null");
                break;
        }
        String str = null;
        str.concat("a1");
        str.concat("ba");
        System.out.println(str);
//		String str1 = "assdxc";
//		String str2 = "assdxc";
//		System.out.println(str1.equals("assdxc"));
//		System.out.println(str1 == str2);
//		System.out.println(str1 == "assdxc");
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		
//		Test3_1 t3_1 = new Test3_1();
//		System.out.println(t3_1.minpath);
    }

}
