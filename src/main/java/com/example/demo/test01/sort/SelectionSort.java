package com.example.demo.test01.sort;

/**
 * @author wu161 2018年8月28日下午1:03:09
 * 时间复杂度       最差		最好		   状态            空间复杂度
 * 选择排序         O(n2)	O(n2)          稳定 	       O(1)
 */
public class SelectionSort {

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            // 找出最小值的小标
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            // 将最小值放到排序序列末尾
            if (k > i) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] b = {49, 38, 65, 97, 76, 13, 27, 50};
        selectionSort(b);
        for (int i : b)
            System.out.print(i + " ");
    }

}
