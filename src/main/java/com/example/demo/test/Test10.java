package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums = n.substring(1, n.length() - 1).split(",");
        Map<Long, Long> map = new HashMap<Long, Long>();
        long result01 = 0;
        long result02 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(Long.valueOf(nums[i]))) {
                map.put(Long.valueOf(nums[i]), map.get(Long.valueOf(nums[i])) + 1);
                if (map.get(Long.valueOf(nums[i])) > result02) {
                    result01 = Long.valueOf(nums[i]);
                    result02 = map.get(result01);
                }
            } else {
                map.put(Long.valueOf(nums[i]), (long) 1);
            }
        }
        if (result02 > nums.length / 2)
            System.out.println(result01);

    }
}

interface f {
    public void test();

    public void test1();
}