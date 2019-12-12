package com.example.demo.test01.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author wu161 2018年8月30日上午10:00:36
 * 给出两个数字x和y，请你比较xy和yx的大小，如果前者大于后者，输出">"，小于则输出"<"，等于则输出"="。
 * 输入：
 * 两个数字x和y。满足1 <= x,y <= 109
 * 输出：
 * 一个字符，">"，"<"或者"="。
 * 输入例子1:
 * 2 2
 * 输出例子1:
 * =
 */

public class Test20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            if (x == y) // 如果x，y相等
            {
                System.out.println("=");
                return;
            }

            String flag = ""; // 记录比较的结果
            double xx = y * Math.log(x);
            double yy = x * Math.log(y);
            if (xx > yy)
                flag = ">";
            else if (xx == yy)
                flag = "=";
            else
                flag = "<";
            System.out.println(flag);
        }

    }
}