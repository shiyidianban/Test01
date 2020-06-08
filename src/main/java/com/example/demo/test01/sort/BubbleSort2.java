package com.example.demo.test01.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author wu161 2018年8月28日下午12:30:54
 * 时间复杂度       最差		最好		   状态            空间复杂度
 * 冒泡排序	       O(n2)	O(n2)	       稳定	           O(1)
 */
public class BubbleSort2 {

    public static void main(String[] args) {

        int[] array = {1, 23, 3, 8, 5, 34, 7, 8, 9, 10};
        System.out.println(JSON.toJSONString(array));
        bubbleSort(array);
        System.out.println(JSON.toJSONString(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

