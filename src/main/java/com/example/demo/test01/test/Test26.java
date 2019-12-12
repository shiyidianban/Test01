package com.example.demo.test01.test;

import java.util.Scanner;

public class Test26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int k = 0;
        while (true) {
            int[] array2 = judge(array);
            if (compareInt(array, array2)) {
                break;
            }
            array = array2;
            k++;
        }
        System.out.println(k - 1);
    }

    public static int[] judge(int[] array) {
        int[] array1 = new int[array.length];
        int num = 0;
        int k = 1;
        for (int i = array.length - 1; i > 0; i--) {

            if (array[i - 1] > array[i]) {
                num = array[i - 1];
            } else {
                num = array[i];
                array1[i] = num;
                k++;
            }
        }
        array1[0] = num;
        int[] array2 = new int[k];
        k = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0) {
                array2[k] = array1[i];
                k++;
            }
        }
        return array2;
    }

    public static boolean compareInt(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}