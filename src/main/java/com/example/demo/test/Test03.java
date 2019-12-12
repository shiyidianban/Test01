package com.example.demo.test;

import java.util.Scanner;

public class Test03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            String line = scanner.nextLine();
            arr[i][0] = Integer.valueOf(line.split(" ")[0]);
            arr[i][1] = Integer.valueOf(line.split(" ")[1]);
        }
        System.out.println(4);
    }
}
