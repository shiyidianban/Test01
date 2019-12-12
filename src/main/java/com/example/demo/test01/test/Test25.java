package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wu161 2018年8月30日上午10:00:36
 * 用x,y表示一个整数范围区间，现在输入一组这样的范围区间(用空格隔开)，请输出这些区间的合并。
 */

public class Test25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] arrayString = data.split(" ");
        //对数组重新排序
        arrayString = sortString(arrayString);
        boolean flase = false;
        String[] arrayString1;
        //对数组进行合并
        while (!flase) {
            arrayString1 = getCombine(arrayString);
            //比较合并之后的数组是否相同
            flase = compareString(arrayString, arrayString1);
            arrayString = arrayString1;
        }
        for (int i = 0; i < arrayString.length; i++) {
            System.out.print(arrayString[i] + " ");
        }
    }

    public static boolean compareString(String[] arrayString, String[] arrayString1) {
        if (arrayString.length == arrayString1.length) {
            for (int i = 0; i < arrayString1.length; i++) {
                if (!arrayString[i].equals(arrayString1[i])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static String[] getCombine(String[] arrayString) {
        List<String> list = new ArrayList<>();
        int min1 = 0;
        int max1 = 0;
        for (int i = 0; i < arrayString.length; i++) {
            int min2 = Integer.valueOf(arrayString[i].split(",")[0]);
            int max2 = Integer.valueOf(arrayString[i].split(",")[1]);
            if (min2 <= max1) {
                if (min2 <= min1)
                    min1 = min2;
                max1 = max2;
            } else if (min1 == 0) {
                min1 = min2;
                max1 = max2;
            } else {
                min1 = min2;
                max1 = max2;
            }
            if (i < arrayString.length - 1) {
                int min3 = Integer.valueOf(arrayString[i + 1].split(",")[0]);
                if (min3 <= max1) {

                } else {
                    list.add(min1 + "," + max1);
                }
            } else {
                list.add(min1 + "," + max1);
            }
        }

        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }

    public static int sortString1(String t1, String t2) {
        if (Integer.valueOf(t1.split(",")[1]) > Integer.valueOf(t2.split(",")[1]))
            return 1;
        else
            return -1;
    }

    public static String[] sortString(String[] test) {
        for (int i = 0; i < test.length - 1; i++) {
            //外层循环控制排序趟数
            for (int j = 0; j < test.length - 1 - i; j++) {
                if (sortString1(test[j], test[j + 1]) > 0) {
                    String temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                }
            }
        }
        return test;
    }
}