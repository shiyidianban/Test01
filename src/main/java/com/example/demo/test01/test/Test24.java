package com.example.demo.test01.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author wu161 2018年9月7日下午12:49:38
 */
public class Test24 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BigDecimal sum = new BigDecimal(1);
        for (int i = 0; i < n; i++) {
            sum = sum.multiply(new BigDecimal(2));
        }
        System.out.println(sum);


    }

}
