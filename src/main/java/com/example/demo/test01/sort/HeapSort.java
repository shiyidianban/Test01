package com.example.demo.test01.sort;

import java.util.Arrays;

/**
 * @author wu161 2018年8月28日下午1:16:11
 * 时间复杂度       最差		            最好    		   状态            空间复杂度
 * 堆排序   	O(n*log2n)	                O(n*log2n)	       不稳定          O(1)
 */
public class HeapSort {

    /**
     * 构建大顶堆
     */
    public static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
} 