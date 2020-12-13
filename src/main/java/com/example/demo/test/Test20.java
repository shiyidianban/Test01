package com.example.demo.test;

import java.util.*;

public class Test20 {

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        int[][] count = new int[intervals.length][2];
        int position = 0;
        count[position] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] count2 = count[position];
            if (intervals[i][0] > count2[1]) {
                position++;
                count[position] = intervals[i];
            } else {
                count2[1] = Math.max(intervals[i][1], count2[1]);
                count[position] = count2;
            }
        }

        int[][] result = new int[position + 1][2];
        for (int i = 0; i <= position; i++) {
            result[i] = count[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] num = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(num));
    }
}