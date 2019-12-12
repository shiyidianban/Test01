package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月28日上午10:15:00
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]A[1]...A[i-1]A[i+1]...A[n-1]。
 * 其中A[i] = 1。不能使用除法，
 * 思路：使用矩阵法求解，将矩阵分为上三角矩阵和下三角矩阵，分别求乘积
 */
public class T52 {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            // 计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            // 计算上三角连乘
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

}
