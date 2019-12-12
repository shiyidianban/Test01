package com.example.demo.test;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(method(x, y));
    }

    static long a[][] = new long[1024][1024];

    public static long method(int row, int line) {
        if (row == 0 || line == 0) {
            a[row][line] = 1;
            return a[row][line];
        } else {
            if (a[row][line] == 0) {

                a[row][line] = method(row - 1, line) + method(row, line - 1);
                return a[row][line];
            } else {
                return a[row][line];
            }
        }
    }
}