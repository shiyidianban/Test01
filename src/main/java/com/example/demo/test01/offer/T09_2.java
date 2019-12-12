package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午12:50:29 现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * .一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 和第一种相同
 * 斐波那契数列是：1、2、3、5、8、13、21……从第3个数开始，每一个数都等于它前面的两个数的和。
 */
public class T09_2 {

    public long fibonacci(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if (n == 0) {
            return preTwo;
        }
        if (n == 1) {
            return preOne;
        }
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
