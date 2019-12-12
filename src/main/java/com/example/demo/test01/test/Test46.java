package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wu161 2018年9月17日下午8:06:57
 */
public class Test46 {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.stream().filter(r -> r.equals("b")).forEach(r ->
        {
            System.out.print(r.equals("b"));
        });
        System.out.print(a.size());
    }


    public static int getValue(int i) {
        int re = 0;
        switch (i) {
            case 3:
                re = re + i;
            case 4:
                re = re + i * 2;
            case 5:
                re = re + i * 3;
        }
        return re;
    }

    private static final String C_CODES_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$.`";

    public static String BaseConvert(String s, int srcBase, int destBase) {
        if (srcBase == destBase) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (destBase != 10) {// 目标进制不是十进制 先转化为十进制
            s = BaseConvert(s, srcBase, 10);
        } else {
            long n = 0;
            for (int i = len - 1; i >= 0; i--) {
                n += C_CODES_STRING.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
            }
            return String.valueOf(n);
        }
        return int2CodeString(Integer.valueOf(s), destBase);
    }

    public static String int2CodeString(long intVal, int base) {

        int w_code_len = C_CODES_STRING.length();
        if (base > w_code_len) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<String>();
        while (intVal != 0) {
            s.push(C_CODES_STRING.charAt((int) (intVal % base)) + "");
            intVal /= base;
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

