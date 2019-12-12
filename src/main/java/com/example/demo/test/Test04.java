package com.example.demo.test;

import java.util.Scanner;

public class Test04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] n = scanner.nextLine().split(" ");
            System.out.print(n[n.length - 1]);
            for (int i = n.length - 2; i >= 0; i--) {
                System.out.print(" " + n[i]);
            }
        }
    }

}
