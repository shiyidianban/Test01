package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午12:53:42
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class T09_3 {

    public int Fibonaccik(int n) {
        int number = 1;
        int sum = 1;
        if (n <= 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        while (n-- >= 2) {
            sum += number;
            number = sum - number;
        }
        return sum;
    }

}
