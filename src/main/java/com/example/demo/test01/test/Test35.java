package com.example.demo.test01.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Map map = new HashMap<>();
        String[] array = line.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int n = (int) map.get(array[i]);
                n += 1;
                map.put(array[i], n);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Object key : map.keySet()) {
            int n = (int) map.get(key);
            if (n >= 2)
                System.out.print(key + " ");
        }
    }
}