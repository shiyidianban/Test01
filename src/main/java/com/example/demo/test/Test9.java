package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test9 {

    public static List<Integer> list = new ArrayList<>();
    public static int min = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        method(array, 0, 0, X);
        System.out.println(list.toString());
        System.out.println(min);

    }

    public static void method(int array[], int i, int sum, int X) {
        for (int j = i; j < array.length; j++) {
            int sum2 = sum + array[j];
            if (sum2 >= X) {
                list.add(sum2);
                if (sum2 < min || min == 0)
                    min = sum2;
            } else {
                method(array, j + 1, sum2, X);
            }
        }
    }

    public static int DPXDisc(int[] num, int m) {
        int n = num.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }
        if (sum < m) {
            return -1;
        } else if (sum == m) {
            return m;
        }

        int[][] dp = new int[n + 1][sum + 1];//初始值默认为0
        for (int i = m; i <= sum; i++) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 0; k <= i; k++) {
                    if (num[j] > k) {
                        dp[j][k] = dp[j + 1][k];
                    } else {
                        dp[j][k] = Math.max(dp[j + 1][k], dp[j + 1][k - num[j]] + num[j]);
                    }
                }
            }
            if (dp[0][i] == i) {
                return i;
            }
        }
        return sum;
    }

    public static int DPXDisc2(int[] price, int x) {
        int sum = 0;
        for (int i = 0; i < price.length; i++) {
            sum += price[i];
        }
        if (sum < x) {
            return -1;
        }
        //背包情境：尽可能多放，相当于从差值中去掉没必要加入的菜品
        int m = sum - x;
        int[] dp = new int[m + 1];
        for (int i = 0; i < price.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (price[i] > j)
                    break;//该菜品必须添加
                dp[j] = Math.max(dp[j - price[i]] + price[i], dp[j]);
            }
        }
        return sum - dp[m];

    }
}