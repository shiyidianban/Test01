package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年8月19日下午1:08:47
 * 输入为n+1个非负整数，用空格分开。其中：首个数字为非负整数序列的最大值n，后面n个数字为子序列中包含的数字。
 */
public class Test13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");

        int n = Integer.parseInt(strs[0]);

        if (n > 0) {
            findNoNumber(str.substring(strs[0].length()), n);
        }

    }

    /**
     * 找到未出现在该子序列中的数
     */
    private static void findNoNumber(String s, int n) {
        if (s == null || s.length() == 0)
            return;
        for (int i = 0; i <= n; i++) {
            if (!s.contains(" " + i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
