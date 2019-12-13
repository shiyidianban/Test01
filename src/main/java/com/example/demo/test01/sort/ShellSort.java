package com.example.demo.test01.sort;

import java.util.Arrays;

/**
 * @author wu161 2018年8月28日下午1:19:39
 * 时间复杂度       最差		最好	        状态            空间复杂度
 * 希尔排序	       O	    O	            不稳定	        O(1)
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        // i表示希尔排序中的第n/2+1个元素（或者n/4+1）
        // j表示希尔排序中从0到n/2的元素（n/4）
        // r表示希尔排序中n/2+1或者n/4+1的值
        int i, j, r, tmp;
        // 划组排序
        for (r = arr.length / 2; r >= 1; r = r / 2) {
            for (i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = tmp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

}
