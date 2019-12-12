package com.example.demo.test01.test;

import java.util.Scanner;

public class Test30 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(getCount(n, m));
    }

    // 0-1背包问题 f(n,m) 转化为两个子问题 f(n-1,m) 和 f(n-1,m-n)
    public static int getCount(int n, int m) {
        if (m < 1 || n < 1)
            return 0;
        if (m < n)
            n = m;
        int sum = 0;
        if (m == n)
            sum++;
        // 不选中n
        sum += getCount(n - 1, m);
        // 选中n
        sum += getCount(n - 1, m - n);
        return sum;
    }
}