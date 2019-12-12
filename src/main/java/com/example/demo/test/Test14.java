package com.example.demo.test;

import java.util.Scanner;

public class Test14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums = n.substring(1, n.length() - 1).split(",");
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int secondMax = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > secondMax && arr[j] < max) {
                secondMax = arr[j];
            }
        }
        int threeMax = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > threeMax && arr[j] < secondMax) {
                threeMax = arr[j];
            }
        }
        System.out.println(threeMax);
    }
}