package com.example.demo.test;

import java.util.Scanner;

public class Test05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[] arr = new int[n];
        boolean result = getResult(arr);
        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    public static boolean getResult(int[] data) {
        int prev, last;
        prev = last = -1;
        int length = data.length;
        // 判断数据的有效性
        if (length == 0 || length == 1) {
            return false;
        } else {
            // 1、先遍历，找出prev以及last的位置
            for (int i = 0; i < length - 1; i++) {
                if (data[i + 1] >= data[i] && prev == -1) {
                    continue;
                } else if (data[i + 1] < data[i] && prev == -1) {
                    prev = i; // prev>-1
                    continue;
                }

                if (prev > -1 && data[i] >= data[i + 1]) {
                    continue;
                } else if (prev > -1 && data[i] < data[i + 1] && last == -1) {
                    last = i;
                    continue;
                }
                // 根据以上，就可以找到第一次升和降的位置；

                // 如果再出现降序，那么直接返回false；
                if (prev > -1 && last > -1 && data[i] > data[i + 1]) {
                    return false;
                }
            }
        }

        // 找到2个值以后，判断反转后是否为升序序列做出判断；
        // 如果初始数列为升序；
        if (prev == -1) {
            return false;
        }
        // 如果初始为降序，那么last=-1；
        if (prev > -1 && last == -1) {
            return true;
        }
        if (prev == 0) {
            if (data[prev] <= data[last + 1]) {
                return true;
            }
        } else if (prev > 0) {
            if (data[prev - 1] <= data[last] && data[prev] <= data[last + 1]) {
                return true;
            }
        }
        return false;
    }

}
