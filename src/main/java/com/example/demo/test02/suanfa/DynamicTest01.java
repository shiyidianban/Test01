package com.example.demo.test02.suanfa;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author FLY
 * @CreateDate 2019-12-19 11:30
 * @ProjectName Test01
 * @Desc
 * 经典的数字三角形问题(简单易懂, 经典动态规划);
 *          7         在数字三角形中寻找一个从顶部到底部数值最大的路径。每一步只能向左下或向右下执行
 *         3 8
 *        8 1 0
 *       2 7 4 4
 *      4 5 2 6 5
 */
public class DynamicTest01 {

    static int n= 5;  //n表示层数

    static int MAX = 101;
    static int[][] D = new int[MAX][MAX];   //存储数字三角形

    @Before
    public void init(){
        D[0][0] = 7;
        D[1][0] = 3; D[1][1] = 8;
        D[2][0] = 8; D[2][1] = 1; D[2][2] = 0;
        D[3][0] = 2; D[3][1] = 7; D[3][2] = 4; D[3][3] = 4;
        D[4][0] = 4; D[4][1] = 5; D[4][2] = 2; D[4][3] = 6; D[4][4] = 5;
    }

    public static void main(String[] args) {
        new DynamicTest01().init();
        System.out.println(getMaxPath(D,5,0,0));
        System.out.println(getMax());
    }

    public static int getMaxPath(int[][] d,int n,int i,int j){
        if(i == n - 1 ){
            return d[i][j];
        }

        int x = getMaxPath(d,n,i+1,j);
        int y = getMaxPath(d,n,i+1,j+1);
        return (x > y ? x:y) + d[i][j];
    }

    public static int getMax(){

        int i = 0; int j = 0;
        int maxSum = getMaxSum(D,n,i,j);
        return maxSum;
    }
    public static int getMaxSum(int[][] D,int n,int i,int j){
        if(i == n - 1){
            return D[i][j];
        }

        int x = getMaxSum(D,n,i+1,j);
        int y = getMaxSum(D,n,i+1,j+1);
        return Math.max(x,y)+D[i][j];
    }


    @Test
    public void testMaxPath(){
        //动态规划
        long max = 0;
        int[][] dp = D;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = dp[i][j];
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + num;
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j])
                            + num;
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }

}
