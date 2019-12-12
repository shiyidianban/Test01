package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * 给出一个非空的字符串，判断这个字符串是否是由它的一个子串进行多次首尾拼接构成的。
 * 例如，"abcabcabc"满足条件，因为它是由"abc"首尾拼接而成的，而"abcab"则不满足条件。
 *
 * @author wu161
 */
public class Test10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = getMaxString(str);
        if (result.equals("")) {
            System.out.println(false);
        } else {
            System.out.println(result);
        }
    }

    public static String getMaxString(String str) {
        String str1 = "";
        String str2 = "";
        for (int i = 1; i < str.length(); i++) {
            str1 = str.substring(0, i);
            if (str.replaceAll(str1, "").equals("") && !str.equals(str1)) {
                str2 = str1;
            }
        }
        return str2;
    }
}

