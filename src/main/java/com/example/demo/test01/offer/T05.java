package com.example.demo.test01.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wu161 2018年8月26日下午12:28:00 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class T05 {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ArrayList<Integer> printListFromTailToHead(List listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        Stack stack = new Stack();
        while (listNode != null) {
            stack.push(listNode);
            //使用链表，需要创建链表
//			listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add((Integer) stack.pop());
        }
        return list;
    }
}
