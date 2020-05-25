package com.example.demo.test01.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author wu161 2018年8月28日下午1:03:09
 * 时间复杂度       最差		最好		   状态            空间复杂度
 * 选择排序         O(n2)	O(n2)          稳定 	       O(1)
 */
public class SelectionSort2 {

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[temp]) {
                    temp = j;
                }
            }

            if (temp > i) {
                int t = a[temp];
                a[temp] = a[i];
                a[i] = t;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 50};
        System.out.println(JSON.toJSONString(array));
        selectionSort(array);
        System.out.println(JSON.toJSONString(array));
    }

}
