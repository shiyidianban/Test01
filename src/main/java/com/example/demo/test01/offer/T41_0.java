package com.example.demo.test01.offer;

import java.util.ArrayList;

/**
 * @author wu161 2018年8月27日下午4:55:16
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：定义两个指针，分别递增，寻找和为s的序列。
 */
public class T41_0 {

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
        T41_0 t = new T41_0();
        ArrayList<ArrayList<Integer>> list = t.FindContinuousSequence(100);
        for (ArrayList<Integer> l : list) {
            System.out.println(l.toString());
        }
    }

}
