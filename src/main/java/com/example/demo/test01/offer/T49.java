package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午10:09:21
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 思路：若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false
 */
public class T49 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int mark = 0;
        int number = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '-')
            mark = 1;
        for (int i = mark; i < chars.length; i++) {
            if (chars[i] == '+') {
                continue;
            }
            if (chars[i] < 48 || chars[i] > 57) {
                return 0;
            }
            number = number * 10 + chars[i] - 48;
        }
        return mark == 0 ? number : -number;
    }

    public static void main(String[] args) {
        T49 t = new T49();
        System.out.println(t.StrToInt("12"));
    }
}
