package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年9月17日下午8:06:57
 */
public class Test41 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            int k = Integer.valueOf(line.split(" ")[0]);
            int l = Integer.valueOf(line.split(" ")[1]);
            int r = Integer.valueOf(line.split(" ")[2]);
            int n4 = get(k, l, r);
            System.out.println(n4);
        }

    }

    public static int get(int k, int l, int r) {
        String n1;
        int n3 = k - 1;
        int count = 0;
        int max = 0;
        int max_j = 0;
        for (int j = l; j < r; j++) {
            n1 = Integer.toString(j, k);
            String[] n2 = n1.split("");
            n3 = k - 1;
            count = 0;
            for (int i = 0; i < n2.length; i++) {
                if (n3 == Integer.valueOf(n2[i])) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                max_j = j;
            }
        }
        return max_j;

    }
}
