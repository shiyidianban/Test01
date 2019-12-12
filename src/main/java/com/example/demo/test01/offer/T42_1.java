package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午9:37:18
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 * 思路：拼接或反转三次字符串
 */
public class T42_1 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return str;
        String s1 = reverse(str.substring(0, n));
        String s2 = reverse(str.substring(n, str.length()));
        return reverse(s2) + reverse(s1);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }
}
