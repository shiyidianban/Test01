package com.example.demo.test;

import java.util.Scanner;

public class Test11 {

    static int[] nums = {1, 2, 1, 3, 1, 2, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums1 = n.substring(1, n.length() - 1).split(",");
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(nums1[i]);
        }
        int result = find(nums, 0, nums.length - 1);
        System.out.println(result);

    }

    public static int find(int[] nums, int begin, int end) {
        if (begin == end)
            return nums[begin];
        else {
            int mid = (begin + end) / 2;
            int left = find(nums, begin, mid);
            int right = find(nums, mid + 1, end);

            if (left == right)//左右两部分的众数相同 则这个数是这部分的众数
                return left;
            else {//左右两部分的众数不相同 则这两个数都有可能是这部分的众数
                //那么遍历这个数组 看一下哪个数字的出现频率高
                int countLeft = 0;
                int countRight = 0;

                for (int i = begin; i <= end; i++)
                    if (nums[i] == left)
                        countLeft++;
                    else if (nums[i] == right)
                        countRight++;

                if (countLeft >= countRight)
                    return left;
                else
                    return right;
            }
        }
    }

}
