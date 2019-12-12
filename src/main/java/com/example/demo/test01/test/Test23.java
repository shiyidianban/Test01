package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年8月30日上午10:00:36
 * 求数列的和 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和
 */

public class Test23 {
    public static void main(String[] args) {
        int m;
        double sum, n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum = sum + n;
                n = Math.sqrt(n);
                System.out.println(n);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }

    }
}