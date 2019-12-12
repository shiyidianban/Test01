package com.example.demo.test01.test;

import java.util.Scanner;
import java.util.Stack;

public class Test29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        char[] nArray = n.toCharArray();
        char[] nArray2 = new char[nArray.length];
        Stack stackN = new Stack();
        if (nArray[0] == '-') {
            for (int i = 1; i < nArray.length; i++) {
                stackN.push(nArray[i]);
            }
            boolean flase = false;
            System.out.print("-");
            for (int i = 1; i < nArray.length; i++) {
                char nc = (char) stackN.pop();
                if (!flase) {
                    if (nc != '0') {
                        flase = true;
                    }
                }
                if (flase) {
                    System.out.print(nc);
                }
            }
        } else if (nArray[0] == '0') {
            System.out.print(0);
        } else {
            for (int i = 0; i < nArray.length; i++) {
                stackN.push(nArray[i]);
            }
            boolean flase = false;
            for (int i = 0; i < nArray.length; i++) {
                char nc = (char) stackN.pop();
                if (!flase) {
                    if (nc != '0') {
                        flase = true;
                    }
                }
                if (flase) {
                    System.out.print(nc);
                }
            }
        }


    }
}
