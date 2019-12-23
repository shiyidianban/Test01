package com.example.demo.test02.Suanfa;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author FLY
 * @CreateDate 2019-12-19 17:40
 * @ProjectName Test01
 * @Desc 背包问题
 * 在N件物品取出若干件放在容量为W的背包里，每件物品的体积为W1，W2……Wn（Wi为整数），与之相对应的价值为P1,P2……Pn（Pi为整数）。求背包能够容纳的最大价值。
 */
public class DynamicTest05 {

    public static void main(String[] args) {

        int[] price = {0, 1, 2, 3};
        int[] weight = {0, 2, 3, 1};
        int n = weight.length - 1;
        int w = 5;
        int[] dp = new int[w + 1];
        long max = 0;
        for (int i = 1; i < n + 1; i++)
            for (int j = w; j > 0; j--)
                if (j - weight[i] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
                else
                    dp[j] = dp[j];
        for (int i = 0; i < w + 1; i++)
            max = max > dp[i] ? max : dp[i];

        System.out.println(max);
    }
}
