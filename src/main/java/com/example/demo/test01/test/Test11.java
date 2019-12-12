package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wu161
 * 2018年8月19日下午1:08:47
 * 给出一个正整数n，请给出所有的包含n个'('和n个')'的字符串，使得'('和')'可以完全匹配。
 * 例如：
 * '(())()'，'()()()' 都是合法的；
 * '())()('是不合法的。
 * 请按照__字典序__给出所有合法的字符串。
 */
public class Test11 {

    static int n = 0;
    static String result = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        listAll("", 2 * n);
        System.out.println(result.replaceFirst(",", ""));
    }

    //输出所有可能
    public static void listAll(String prefix, int sum) {
        if (prefix.length() == sum) {
            if (isString(prefix))
                result = result + "," + prefix;
        } else {
            String prefix1 = prefix + "(";
            listAll(prefix1, sum);
            String prefix2 = prefix + ")";
            listAll(prefix2, sum);
        }
    }

    //判断输出是否合法
    public static boolean isString(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = (char) stack.peek();
                switch (c) {
                    case ')':
                        if (temp == '(') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> result = new ArrayList<>();
        printHelper(n, n, "", result);

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                System.out.print(result.get(i) + ",");
            } else {
                System.out.print(result.get(i));
            }
        }
    }

    private static void printHelper(int left, int right, String out, List<String> result) {

        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }

        printHelper(left - 1, right, out + "(", result);
        printHelper(left, right - 1, out + ")", result);

    }

}
