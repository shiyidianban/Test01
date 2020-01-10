package com.example.demo.test02.suanfa;

/**
 * @author FLY
 * @date 2019-12-23 11:37
 * 正整数分组
 * <p>
 * 将一堆正整数分为2组，要求2组的和相差最小。
 * 例如：1 2 3 4 5，将1 2 4分为1组，3 5分为1组，两组和相差1，是所有方案中相差最少的。
 */
public class DynamicTest09 {

    public static void main(String[] args) {
        long sum = 0, max = 0;
        int[] nums = {1, 2, 3, 4, 5};
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int[] dp = new int[(int) (sum / 2 + 1)];
        for (int i = 0; i < n; i++)
            for (int j = (int) (sum / 2); j > 0; j--)
                if (j >= nums[i])
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

        for (int i = 1; i < sum / 2 + 1; i++)
            max = max > dp[i] ? max : dp[i];
        System.out.println(Math.abs((sum - max) - max));
    }
}
