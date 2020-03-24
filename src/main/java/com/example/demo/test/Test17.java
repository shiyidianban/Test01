package com.example.demo.test;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;


public class Test17 {
    private static final String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] chs = str.toCharArray();
    private static final BigInteger zero = new BigInteger("0");


    /**
     * 10进制转任意进制
     */
    public static String numToRadix(String number, int radix) {
        if (radix < 0 || radix > str.length()) {
            radix = str.length();
        }

        BigInteger bigNumber = new BigInteger(number);
        BigInteger bigRadix = new BigInteger(radix + "");

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        while (!bigNumber.equals(zero)) {
            stack.add(chs[bigNumber.remainder(bigRadix).intValue()]);
            bigNumber = bigNumber.divide(bigRadix);
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    /**
     * 任意进制转10进制
     */
    public static String radixToNum(String number, int radix) {
        if (radix < 0 || radix > str.length()) {
            radix = str.length();
        }
        if (radix == 10) {
            return number;
        }

        char ch[] = number.toCharArray();
        int len = ch.length;

        BigInteger bigRadix = new BigInteger(radix + "");
        BigInteger result = new BigInteger("0");
        BigInteger base = new BigInteger("1");


        for (int i = len - 1; i >= 0; i--) {
            BigInteger index = new BigInteger(str.indexOf(ch[i]) + "");
            result = result.add(index.multiply(base));
            base = base.multiply(bigRadix);
        }

        return result.toString();
    }


    /**
     * 任意进制之间的互相转换, 先将任意进制转为10进制, 然后在转换为任意进制
     */
    public static String transRadix(String num, int fromRadix, int toRadix) {
        return numToRadix(radixToNum(num, fromRadix), toRadix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] num = n.split(" ");
        System.out.println(transRadix(num[1], Integer.valueOf(num[0]), Integer.valueOf(num[2])));
    }

}