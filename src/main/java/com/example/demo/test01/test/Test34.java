package com.example.demo.test01.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int n = Integer.valueOf(line.split(" ")[0]);
        int m = Integer.valueOf(line.split(" ")[1]);
        int p = Integer.valueOf(line.split(" ")[2]);
        Integer[] narray = new Integer[n];
        line = scan.nextLine();
        for (int i = 0; i < narray.length; i++) {
            narray[i] = Integer.valueOf(line.split(" ")[i]);
        }
        for (int i = 0; i < m; i++) {
            line = scan.nextLine();
            String a = line.split(" ")[0];
            int b = Integer.valueOf(line.split(" ")[1]);
            if ("A".equals(a)) {
                narray[b - 1]++;
            } else if ("B".equals(a)) {
                narray[b - 1]--;
            }
        }
        int p1 = narray[p - 1];
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        Arrays.sort(narray, cmp);
        Map narrayHash = new HashMap<>();
        for (int i = 0; i < narray.length; i++) {
            if (!narrayHash.containsKey(narray[i]))
                narrayHash.put(narray[i], i);
        }
        int result = (int) narrayHash.get(p1);
        result += 1;
        System.out.println(result);
    }
}