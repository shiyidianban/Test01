package com.example.demo.test01.test;

import java.util.Scanner;

public class Test05 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int i, j, end, start;
        int[] locations1 = new int[num1];
        for (i = 0; i < num1; i++) {
            locations1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        int[] locations2 = new int[num2];
        for (i = 0; i < num2; i++) {
            locations2[i] = sc.nextInt();
        }
        for (i = 0; i < locations2.length; i++) {
            end = 0;
            start = 0;
            for (j = 0; j < locations1.length; j++) {
                start = end;
                end = end + locations1[j];
                if (start < locations2[i] && locations2[i] <= end) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}