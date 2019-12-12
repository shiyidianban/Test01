package com.example.demo.test01.offer;

import java.util.LinkedList;

/**
 * @author wu161 2018年8月27日下午9:59:32
 * 圆圈中最后剩下的数字（约瑟夫环）
 * 思路：利用循环链表实现
 */
public class T45 {

    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int bt = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
