package com.example.demo.test01.test;

import java.util.HashMap;
import java.util.Scanner;

public class Test42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] data = str.toCharArray();
        int size = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                size++;
            }
        }
        size++;
        char[] data0 = new char[size];
        int[] num0 = new int[size];
        int intdex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                num++;
            } else {
                data0[intdex] = data[i - 1];
                num0[intdex] = num;
                intdex++;
                num = 1;
            }
        }
        data0[intdex] = data[data.length - 1];
        num0[intdex] = num;

        int max = -1;
        int index = -1;
        for (int i = 0; i < num0.length - 2; i++) {
            if (num0[i] > num0[i + 1] && num0[i + 2] > num0[i + 1]) {
                if (max < Math.min(num0[i], num0[i + 2])) {
                    max = Math.min(num0[i], num0[i + 2]);
                    index = i;
                }
            }
        }

        if (index >= 0) {
            int num2 = Math.min(num0[index], num0[index + 2]);
            for (int i = 0; i < num2; i++) {
                System.out.print(data0[index]);
            }
            for (int i = 0; i < num0[index + 1]; i++) {
                System.out.print(data0[index + 1]);
            }
            for (int i = 0; i < num2; i++) {
                System.out.print(data0[index + 2]);
            }
            System.out.println();
        } else {
            System.out.println("NULL");
        }
    }
}