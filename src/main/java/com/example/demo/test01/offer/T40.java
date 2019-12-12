package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午1:57:59
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：两个相同的数异或后为0，将所有数异或后得到一个数，然后求得1在该数最右边出现的index，然后判断每个数右移index后是不是1。
 */
public class T40 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null)
            return;
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        for (int i = 1; i < array.length; i++)
            number ^= array[i];
        // 异或后的数1出现在第几位
        int index = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            // 判断第index位是不是0
            boolean isBit = ((array[i] >> index) & 1) == 0;
            if (isBit) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        T40 t = new T40();
        int[] array = {4, 4, 1, 1, 2, 2, 3, 3, 7, 7, 6, 8};
        int[] num1 = new int[array.length];
        int[] num2 = new int[array.length];
        t.FindNumsAppearOnce(array, num1, num2);
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < num2.length; i++) {
            System.out.print(num2[i] + " ");
        }
        System.out.println();
    }
}
