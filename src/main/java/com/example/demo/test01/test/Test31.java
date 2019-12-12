package com.example.demo.test01.test;

import java.util.Scanner;

public class Test31 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int j = 0;
        for (int c = 1; c <= N; c++)
            for (int b = 1; b <= c; b++) {
                for (int a = 1; a <= b; a++) {
                    if ((a * a + b * b) == c * c) {
                        System.out.println(a + " " + b + " " + c);
                        if (sugoushu(a, b, c)) {
                            j++;
                        }
                    }
                }
            }
        System.out.println(j);

    }

    public static boolean sugoushu(int a, int b, int c) {
        int j = 0;

        for (int i = 2; i <= a; i++) {
            if ((a % 2 == 0) && (b % 2 == 0) && (c % 2 == 0)) {
                return true;
            }
        }
        if (j != 0) {
            return false;
        } else {
            return true;
        }

    }
}
