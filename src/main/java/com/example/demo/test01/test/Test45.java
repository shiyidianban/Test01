package com.example.demo.test01.test;

import java.util.Scanner;

public class Test45 {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 15;
        int[][] arr = {{10, 5, 7, 8}, {0, 0, 0, 0}};
        int[][] arr1 = {{10, 4, 8, 8}, {0, 0, 0, 0}};
        get(n, arr, 0, 0);
        System.out.println(count);


    }

    public static void get(int n, int[][] arr1, int start, int sum) {
        int a = 0;
        int[][] arr = copy(arr1);
        if (sum == 15) {
            count++;
            //然后还是从0开始
            get(n, arr, start, 0);
        } else if (sum > 15) {
            int su = sum - arr[0][start - 1];
            count++;
            get(n, arr, start - 1, 0);
        } else if (sum < 15) {
            int su = sum + arr[0][start];
            arr[1][start] = 1;
            get(n, arr, start + 1, su);
        }
        a++;
    }

    public static int[][] copy(int[][] array) {
        int[][] array2 = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array2[i][j] = array[i][j];
            }
        }
        return array2;
    }
}