package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161
 * 2018年8月19日下午1:08:47
 * <p>
 * 给出一个整数n，将n分解为至少两个整数之和，使得这些整数的乘积最大化，输出能够获得的最大的乘积。
 * 例如：
 * 2=1+1，输出1；
 * 10=3+3+4，输出36。
 */
public class Test12 {

    public static int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(integerBreak(n));
    }

}
