package com.example.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wu161 2018年9月26日下午7:41:56
 */
public class asd2 {

    public static void main(String args[]) {
        String[] test = "201811191036.doc".split(".");
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        String test1 = "201811191036232323232323.doc";
        Pattern pattern = Pattern.compile("[0-9]*.doc");
        Matcher isNum = pattern.matcher(test1);
        if (!isNum.matches()) {
            System.out.println("NO");
        } else {
            System.out.println("yes");
        }

    }
}
