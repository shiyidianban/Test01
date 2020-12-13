package com.example.demo.test01.sort;

/**
 * @author wu161 2018年8月28日下午12:30:54
 * 时间复杂度       最差		最好		   状态            空间复杂度
 * 冒泡排序	       O(n2)	O(n2)	       稳定	           O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //内层循环控制每一趟排序多少次，倒序循环
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    n++;
                    System.out.print(n + " ");
                }
            }
        }
        return arr;
    }
}
