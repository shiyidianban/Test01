package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午10:09:21
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * 思路：利用位运算
 */
public class T47 {

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位（1+1）
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
