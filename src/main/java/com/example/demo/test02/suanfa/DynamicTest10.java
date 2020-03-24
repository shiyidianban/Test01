package com.example.demo.test02.suanfa;

/**
 * 给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，每个数的值表示你从这个位置可以跳跃的最大长度。计算如何以最少的跳跃次数跳到最后一个数。
 *
 * @author FLY
 * @date 2020-03-17 14:38
 */
public class DynamicTest10 {

    public static void main(String[] args) {
        int[] num = {2, 3, 2, 1, 2, 1, 5};
        System.out.println(jump(num));

    }

    public static int jump(int[] step) {
        int size = step.length;
        int dp[] = new int[size];
        dp[0] = 0;
        for (int i = 1; i < size; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + step[j] >= i) {// 在第j个位置能跳到第i个位置的情况下
                    dp[i] = Math.min(dp[i], dp[j] + 1);// 比较从哪个位置跳所需的步数最少
                }
            }
        }

        if (dp[size - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[size - 1];
        }
    }
}
