package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年8月30日上午10:00:36
 * 给出一个含有n个数字的序列a1,a2,a3,...an，可以进行以下操作：
 * 一次操作定义为对这个序列的每个数字进行以下两种改变之一：
 * 1.ai ÷ 2
 * 2.ai × 3
 * 每一次的操作中，必须保证至少有一个数字是第1种改变；并且经过每次操作后，每一个数字都必须是整数。
 * 牛牛得知，每进行一次操作，他就可以得到一颗西瓜糖，但是由于孱弱的数学功底，
 * 他不知道何时该对某一个数字进行第一种还是第二种改变，这使得他十分纠结，于是他找来了睿智的你，希望你帮他计算出，他最多可以得到多少颗西瓜糖。
 * 输出
 * 第一行：一个整数n，表示序列中数字的个数，1 <= n <= 10000；
 * 第二行：n个数字，每个数字ai满足1 <= ai  <= 109。
 * 输入：
 * 一个整数，表示最多可以得到的西瓜糖的颗数。
 * 输入例子1:
 * 2
 * 1 4
 * 输出例子1:
 * 2
 */

public class Test19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int sum = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 == 0) {
                    nums[i] = nums[i] / 2;
                    sum++;
                    flag = true;
                }
            }
        }
        System.out.println(sum);
    }
}