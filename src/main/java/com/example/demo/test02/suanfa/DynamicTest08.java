package com.example.demo.test02.suanfa;

/**
 * @Author FLY
 * @CreateDate 2019-12-23 11:25
 * @ProjectName Test01
 * @Desc 最长公共子序列Lcs
 * 给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。
 * 比如两个串为：
 *
 * abcicba
 * abdkscab
 *
 * ab是两个串的子序列，abc也是，abca也是，其中abca是这两个字符串最长的子序列。
 */
public class DynamicTest08 {

    public static void main(String[] args) {
        String aStr = "abcicba";
        String bStr = "abdkscab";
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 1; i < aLen + 1; i++)
            for (int j = 1; j < bLen + 1; j++)
                if (dp[i - 1][j] == dp[i][j - 1] && aStr.charAt(i - 1) == bStr.charAt(j - 1)
                        && dp[i - 1][j] == dp[i - 1][j - 1])
                    dp[i][j] = dp[i - 1][j] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        int max = dp[aLen][bLen];
        StringBuilder sb = new StringBuilder();
        while (max > 0) {
            if (dp[aLen - 1][bLen] == dp[aLen][bLen - 1] && dp[aLen - 1][bLen] + 1 == dp[aLen][bLen]) {
                sb.append(aStr.charAt(aLen - 1));
                max--;
                aLen--;
                bLen--;
            } else {
                if (dp[aLen][bLen - 1] == dp[aLen][bLen])
                    bLen--;
                else
                    aLen--;
            }
        }

        System.out.println(sb.reverse().toString());
    }

}
