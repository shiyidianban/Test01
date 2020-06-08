package com.example.demo.test01.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author wu161 2018年8月28日下午1:09:33
 * 时间复杂度       最差		最好		    状态            空间复杂度
 * 插入排序        O(n2)	    O(n2)	        稳定	        O(1)
 */
public class InsertionSort2 {

    public static void main(String[] args) {
        // 需要进行排序的数组
        int[] array = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
        System.out.println(JSON.toJSONString(array));
        for (int i = 1; i < array.length; i++) {
            int insertNode = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > insertNode) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = insertNode;
        }

        System.out.println(JSON.toJSONString(array));
    }

}
