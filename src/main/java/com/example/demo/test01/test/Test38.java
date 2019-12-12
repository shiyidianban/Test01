package com.example.demo.test01.test;

/**
 * @author wu161 2018年9月17日下午3:12:23
 */
public class Test38 {
    public static void main(String[] args) {
        getResult(3);
    }

    public static void getResult(int n) {
        double num1 = 1;
        double num2 = 0;
        for (int i = 1; i <= n; i++) {
            num1 = num1 * i;
            double num3 = 1;
            for (int j = 1; j <= i; j++) {
                num3 = num3 * j;
            }
            if (i != 1 && i % 2 == 0) {
                num2 = num2 + 1 / num3;
            } else if (i != 1 && i % 2 != 0) {
                num2 = num2 - 1 / num3;
            }
        }
        double num = num1 * num2;
        System.out.println(String.format("%.0f", num));
    }


}  
