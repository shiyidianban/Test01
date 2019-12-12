package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test07 {
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        ArrayList<Integer> list = new ArrayList(n * m);
        int[] clockwiseArray = new int[n * m];
        int left = -1;
        int right = m;
        int up = 0;
        int down = n;
        int total = n * m;
        int count = 0;
        int j = 0;
        int i = 0;
        while (true) {
            for (; j < right; j++) {
                list.add(mat[i][j]);
                count++;
            }
            right--;
            j = right;
            i++;
            if (count >= total) {
                break;
            }

            for (; i < down; i++) {
                list.add(mat[i][j]);
                count++;
            }
            down--;
            i = down;
            j--;
            if (count >= total) {
                break;
            }

            for (; j > left; j--) {
                list.add(mat[i][j]);
                count++;
            }
            left++;
            j = left;
            i--;
            if (count >= total) {
                break;
            }

            for (; i > up; i--) {
                list.add(mat[i][j]);
                count++;
            }
            up++;
            i = up;
            j++;
            if (count >= total) {
                break;
            }
        }

        for (int k = 0; k < list.size(); k++) {
            clockwiseArray[k] = (int) list.get(k);
        }
        return clockwiseArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mun = new int[m][n];
        for (int i = 0; i < mun.length; i++) {
            for (int j = 0; j < mun[i].length; j++) {
                mun[i][j] = sc.nextInt();
            }
        }
//		int[][] mun = {{1,2,3},{4,5,6},{7,8,9}};
        int[] arr = clockwisePrint(mun, mun.length, mun[0].length);
        for (int j = 0; j < arr.length; j++)//利用嵌套for循环来遍历二维数组
        {
            System.out.println(arr[j]);
        }

    }
}