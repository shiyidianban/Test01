package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午12:33:09 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一半
 */
public class T29 {

    public int MoreThanHalfNum_Solution(int[] array) {
        int maxCount = array[0];
        int number = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (number != array[i]) {
                if (count == 0) {
                    number = array[i];
                    count = 1;
                } else {
                    count--;
                }
            } else {
                count++;
            }
            if (count == 1) {
                maxCount = number;
            }
        } // 验证
        int num = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == maxCount) {
                num++;
            }
        }
        if (num * 2 > array.length) {
            return maxCount;
        }
        return 0;
    }

    public static void main(String[] args) {
        T29 t = new T29();
        int[] array = {4, 4, 4, 4, 4, 4, 3, 3, 3, 5, 6, 6, 8};
        System.out.println(t.MoreThanHalfNum_Solution(array));
    }

}
