package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine().split(" ")[0]);
        long[][] arr = new long[n][3];
        for (int i = 0; i < n; i++) {
            String lien = sc.nextLine();
            arr[i][0] = Long.valueOf(lien.split(" ")[0]);
            arr[i][1] = Long.valueOf(lien.split(" ")[1]);
            arr[i][2] = Long.valueOf(lien.split(" ")[2]);

        }
        for (int i = 0; i < n; i++) {
            int cout = get(arr[i][0], arr[i][1], arr[i][2]);
            System.out.println(cout - 3);
        }


    }

    public static int get(long n1, long n2, long n3) {
        List<Long> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                long n = Math.abs(list.get(i) - list.get(j));
                if (!list.contains(n)) {
                    list.add(n);
                    length++;
                }
            }
        }
        return length;
    }
}