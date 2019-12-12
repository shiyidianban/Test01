package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月28日上午10:23:58
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 思路：借助辅助空间进行判断，如字符数组
 */
public class T55 {

    char[] chars = new char[256];
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        sb.append(ch);
        chars[ch]++;
    }

    public char FirstAppearingOnce() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if (chars[c] == 1) {
                return c;
            }
        }
        return '#';
    }

}
