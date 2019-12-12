package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午12:22:46
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完
 * 成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class T03 {

    public boolean find(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
