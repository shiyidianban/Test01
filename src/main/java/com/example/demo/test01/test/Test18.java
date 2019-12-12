package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161
 * 给定一个m行n列的二维地图, 初始化每个单元都是水.
 * 操作addLand 把单元格(row,col)变成陆地.
 * 岛屿定义为一系列相连的被水单元包围的陆地单元, 横向或纵向相邻的陆地称为相连(斜对角不算).
 * 在一系列addLand的操作过程中, 给出每次addLand操作后岛屿的个数.
 * 二维地图的每条边界外侧假定都是水.
 */
public class Test18 {
    public static void check(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1)
            return;
        if (arr[i][j] == 1) {
            arr[i][j] = 2;
            check(arr, i - 1, j);
            check(arr, i + 1, j);
            check(arr, i, j + 1);
            check(arr, i, j - 1);
        }
    }

    public static int getTimes(int[][] arr) {
        int res = 0;
        int help[][] = arr.clone();
        for (int tar = 0; tar < arr.length; tar++) {
            help[tar] = arr[tar].clone();
        }
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                if (help[i][j] == 1) {
                    check(help, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int i = cin.nextInt();
        int j = cin.nextInt();
        int k = cin.nextInt();
        int a[] = new int[k];
        int arr[][] = new int[i][j];
        for (int y = 0; y < k; y++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            if (n + 1 <= i && m + 1 <= j) {
                arr[n][m] = 1;
            }

            a[y] = getTimes(arr);
        }
        for (int num = 0; num < a.length - 1; num++) {
            System.out.print(a[num] + " ");
        }
        System.out.print(a[a.length - 1]);
    }
}
