package com.example.demo.test02.Suanfa;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author FLY
 * @CreateDate 2019-12-19 17:40
 * @ProjectName Test01
 * @Desc
 * 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。
 *
 * 1 3 3
 * 2 1 3
 * 2 2 1
 *
 * 能够获得的最大价值为：11。
 */
public class DynamicTest04 {

    static int n= 3;  //n表示层数

    static int MAX = 101;
    static int[][] D = new int[MAX][MAX];   //存储数字三角形

    @Before
    public void init(){
        D[0][0] = 1; D[0][1] = 3; D[0][2] = 3;
        D[1][0] = 2; D[1][1] = 7; D[1][2] = 3;
        D[2][0] = 2; D[2][1] = 2; D[2][2] = 1;
    }

    @Test
    public void getMax(){
        long max = 0;
        for (int i = 0 ; i < n ; i++ ){
            for (int j = 0 ; j <= n ; j++ ){
                int num = D[i][j];
                if(i == 0 && j == 0)
                    D[i][j] = num;
                else if(i == 0)
                    D[i][j] = D[i][j - 1] + num;
                else if (j == 0)
                    D[i][j] = D[i - 1][j] + num;
                else
                    D[i][j] = Math.max(D[i][j - 1], D[i - 1][j]) + num;
                max = Math.max(D[i][j], max);
            }
        }

        System.out.println(max);
    }

    @Test
    public void getMax2(){
        int[] dp = new int[n + 1];
        int[] readArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < n + 1; k++)
                readArr[k] =  D[i][k-1];
            for (int j = 1; j < n + 1; j++)
                dp[j] = Math.max(dp[j], dp[j - 1]) + readArr[j];
        }
        System.out.println(dp[n]);
    }
}
