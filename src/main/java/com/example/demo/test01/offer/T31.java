package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午12:46:28
 * 求连续子数组（包含负数）的最大和
 * 思路：若和小于0，则将最大和置为当前值，否则计算最大和。
 */
public class T31 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int cur = array[0];
        int greast = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cur < 0) {
                cur = array[i];
            } else {
                cur += array[i];
            }
            if (cur > greast) {
                greast = cur;
            }
        }
        return greast;
    }

    public static void main(String[] args) {
        T31 t = new T31();
        int[] array = {-10, 10, 12, -5, 10};
        int num = t.FindGreatestSumOfSubArray(array);
        System.out.println(num);
    }

}
