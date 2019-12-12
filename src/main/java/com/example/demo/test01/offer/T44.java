package com.example.demo.test01.offer;

import java.util.Arrays;

/**
 * @author wu161 2018年8月27日下午9:59:32
 * 扑克牌的顺子
 * 思路：用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子。
 */
public class T44 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;
        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count++;
                continue;
            }
            if (numbers[i] != numbers[i + 1]) {
                diff += numbers[i + 1] - numbers[i] - 1;
            } else {
                return false;
            }
        }
        if (diff <= count)
            return true;
        return false;
    }
}
