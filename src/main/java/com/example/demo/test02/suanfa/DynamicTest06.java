package com.example.demo.test02.suanfa;

import org.junit.Test;

/**
 * @Author FLY
 * @CreateDate 2019-12-23 9:50
 * @ProjectName Test01
 * @Desc 最长递增子序列
 * 给出长度为N的数组，找出这个数组的最长递增子序列。
 * (递增子序列是指，子序列的元素是递增的）
 * 例如：5 1 6 8 2 4 5 10，最长递增子序列是1 2 4 5 10。
 */
public class DynamicTest06 {

    public static void main(String[] args) {
        int[] L = {5, 1, 6, 8, 2, 4, 5, 10};
        int n = L.length;
        int[] max = new int[n];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (L[i] > L[j] && max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                    maxLen = max[i] > maxLen ? max[i] : maxLen;
                }
            }
        }

        System.out.println(maxLen + 1);
    }

    @Test
    public void test01() {
        int[] L = {5, 1, 6, 8, 2, 4, 5, 10};
        int n = L.length;
        double[] B = new double[n + 1];
        B[0] = Integer.MIN_VALUE;
        B[1] = L[0];
        int Len = 1;
        int p, r, m;
        for (int i = 1; i < n; i++) {
            p = 0;
            r = Len;
            while (p <= r) {
                m = (p + r) / 2;
                if (B[m] < L[i])
                    p = m + 1;
                else
                    r = m - 1;
            }
            B[p] = L[i];
            if (p > Len)
                Len++;
        }

        System.out.println(Len);
    }

}
