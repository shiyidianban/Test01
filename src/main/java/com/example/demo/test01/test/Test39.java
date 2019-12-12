package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年9月17日下午3:12:23
 */
public class Test39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        if (n > 2) {
            int count = 0;
            for (int i = 2; i < array.length; i++) {
                if (get(array, i) != -1) {
                    count = i;
                    break;
                }
            }
            if (count != 0) {
                System.out.println(count + 1);
            } else {
                System.out.println("-1");
            }
        } else {
            System.out.println("-1");
        }
    }

    public static int get(int[] array, int i) {
        int max = 0;
        int max_j = 0;
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            if (array[j] > max) {
                max = array[j];
                max_j = j;
            }
            sum = sum + array[j];
        }
        sum = sum - array[max_j];
        if (sum > max) {
            return i;
        } else {
            return -1;
        }
    }
}  
