package com.example.demo.test01.test;

/**
 * @author wu161 2018年8月30日上午10:32:27
 * 一般的括号匹配问题是这样的：
 * 给出一个字符串，判断这个括号匹配是不是合法的括号匹配。
 * 如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。
 * 这个问题解决起来非常简单，相信大家都知道怎么解决。
 * 现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，
 * 请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，
 * 那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。
 */

import java.util.HashMap;
import java.util.Scanner;

public class Test21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        HashMap<Integer, Integer> positive = new HashMap<>();
        HashMap<Integer, Integer> negtive = new HashMap<>();
        int m = 0, count = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int c = 0, min = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                    c++;
                else if (s.charAt(j) == ')')
                    c--;
                else ;
                if (c < 0) {
                    flag = true;
                    if (c < min)
                        min = c;
                }
            }
            if (!flag && c == 0)
                m++;
            if (!flag && c > 0) {
                if (positive.get(c) != null)
                    positive.put(c, positive.get(c) + 1);
                else
                    positive.put(c, 1);
                if (negtive.get(-c) != null)
                    count += negtive.get(-c);
            }
            if (c < 0 && c == min) {
                if (negtive.get(c) != null)
                    negtive.put(c, negtive.get(c) + 1);
                else
                    negtive.put(c, 1);
                if (positive.get(-c) != null)
                    count += positive.get(-c);
            }
        }
        count += m * m;
        System.out.println(count);
    }
}
