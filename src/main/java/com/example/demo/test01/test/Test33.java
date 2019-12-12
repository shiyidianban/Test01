package com.example.demo.test01.test;

import java.util.Scanner;

public class Test33 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        int[] ni = new int[n.length()];
        for (int i = 0; i < ni.length; i++) {
            ni[i] = Integer.valueOf(n.split("")[i]);
        }
        int ni1 = ni[0] + ni[1] + ni[2];
        int ni2 = ni[3] + ni[4] + ni[5];

        if (ni1 == ni2) {
            System.out.println(0);
        } else {
            int nmax = ni1 > ni2 ? ni1 : ni2;
            int nmin = ni1 > ni2 ? ni2 : ni1;
            int ni3 = nmax - nmin;
            if (ni3 < 10) {
                System.out.println(1);
            } else if (ni3 > 18) {
                System.out.println(3);
            } else {
                System.out.println(2);
            }
        }
    }
}