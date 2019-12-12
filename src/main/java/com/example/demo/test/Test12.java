package com.example.demo.test;

import java.util.Scanner;

public class Test12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums1 = n.substring(1, n.length() - 1).split(",");
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(nums1[i]);
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int num = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = num;
                }
            }
        }
        System.out.println(nums[2]);
    }
}