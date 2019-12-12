package com.example.demo.test01.test;

import java.util.*;

public class Test06 {
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] a = new int[n * m];
        int z = 0;
        int count = 0;
        int count1; // 横坐标循环的次数
        int i, j, k, r, s;
        if (n < m) {
            if (n % 2 == 0) {
                count1 = n / 2;
            } else {
                count1 = n / 2 + 1;
            }
        } else {
            if (m % 2 == 0) {
                count1 = n / 2;
            } else {
                count1 = n / 2 + 1;
            }
        }

        for (i = 0; i < count1; i++) {
            for (j = i; j < m - i; j++) {// 列数
                a[z] = mat[i][j];
                z++;
            }
            for (k = i + 1; k < n - i; k++) {// 行数
                a[z] = mat[k][j - 1];
                z++;
            }
            for (r = m - i - 2; r > i; r--) {// 列数
                a[z] = mat[k - 1][r];
                z++;
            }
            for (s = n - i - 2; s > i + 1; s--) {// 行数
                a[z] = mat[s][r + 1];
                z++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] mun = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] arr = clockwisePrint(mun, mun.length, mun[0].length);
        for (int j = 0; j < arr.length; j++)//利用嵌套for循环来遍历二维数组
        {
            System.out.print(arr[j] + "  ");
        }

    }

}
