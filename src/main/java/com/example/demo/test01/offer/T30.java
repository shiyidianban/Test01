package com.example.demo.test01.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wu161 2018年8月27日下午12:46:28
 * 输入n个整数，找出其中最小的K个数。
 * 思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
 */
public class T30 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        // 创建大根堆
        buildHeap(kArray);
        for (int i = k; i < input.length; i++) {
            if (input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }
        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;
    }

    public void buildHeap(int[] input) {
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            maxHeap(input, i);
        }
    }

    private void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = 0;
        if (left < array.length && array[left] > array[i])
            largest = left;
        else
            largest = i;
        if (right < array.length && array[right] > array[largest])
            largest = right;
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

    public static void main(String[] args) {
        T30 t = new T30();
        int[] array = {4, 5, 6, 8, 9, 3, 2, 12};
        ArrayList<Integer> list = t.GetLeastNumbers_Solution(array, 5);
        System.out.println(list.toString());
    }

}
