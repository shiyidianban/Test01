package com.example.demo.test01.offer;

import java.util.ArrayList;

/**
 * @author wu161 2018年8月27日下午4:55:16
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是最先出现的两个数乘积最小
 */
public class T41_1 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (sum < 3)
            return arrayList;
        int small = 1;
        int big = 2;
        while (small < (sum + 1) / 2) {
            int s = 0;
            for (int i = small; i <= big; i++) {
                s += i;
            }
            if (s == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                arrayList.add(new ArrayList<>(list));
                list.clear();
                small++;
            } else {
                if (s > sum) {
                    small++;
                } else {
                    big++;
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        T41_1 t = new T41_1();
        ArrayList<ArrayList<Integer>> list = t.FindContinuousSequence(100);
        for (ArrayList<Integer> l : list) {
            System.out.println(l.toString());
        }
    }

}
