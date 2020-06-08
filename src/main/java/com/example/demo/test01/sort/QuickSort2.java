package com.example.demo.test01.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author wu161 2018年8月28日下午12:52:35
 * 时间复杂度       最差		最好		            状态            空间复杂度
 * 快速排序	       O(n2)	O(n*log2n)          	不稳定         	O(log2n)~O(n)
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println(JSON.toJSONString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(JSON.toJSONString(array));

    }

    public static void quickSort(int[] array, int low, int high) {
        int start = low;
        int end = high;
        int c = start;
        while (start < end) {

            while (end > start && array[end] >= array[c]) {
                end--;
            }

            if (array[c] >= array[end]) {
                int temp = array[c];
                array[c] = array[end];
                array[end] = temp;
                c = end;
            }

            while (end > start && array[start] <= array[c]) {
                start++;
            }

            if (array[c] <= array[start]) {
                int temp = array[c];
                array[c] = array[start];
                array[start] = temp;
                c = start;
            }


        }

        if (low < c) {
            quickSort(array, low, c - 1);
        }

        if (c < high) {
            quickSort(array, c + 1, high);
        }
    }

}
