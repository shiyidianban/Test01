package com.example.demo.test01.sort;

/**
 * @author wu161 2018年8月28日下午1:09:33
 * 时间复杂度       最差		最好		    状态            空间复杂度
 * 插入排序        O(n2)	    O(n2)	        稳定	        O(1)
 */
public class InsertionSort {

    public static void main(String[] args) {
        // 需要进行排序的数组
        int[] array = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
        // 输出原数组的内容
        printResult(array);
        // 直接插入排序操作
        insertionSort(array);
        // 输出排序后的相关结果
        printResult(array);
    }

    public static void insertionSort(int[] source) {
        int i, j;
        int insertNode;// 要插入的数据
        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < source.length; i++) {
            // 设置数组中的第2个元素为第一次循环要插入的数据
            insertNode = source[i];
            j = i - 1;
            // 如果要插入的元素小于第j个元素，就将第j个元素向后移
            while ((j >= 0) && insertNode < source[j]) {
                source[j + 1] = source[j];
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
            source[j + 1] = insertNode;
            System.out.print("第" + i + "趟排序：");
            printResult(source);
        }
    }

    private static void printResult(int[] array) {
        for (int value : array)
            System.out.print(" " + value + " ");
        System.out.println();
    }

}
