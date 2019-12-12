package com.example.demo.test;

import java.util.Stack;

/**
 * @author superYC
 * 两个栈实现一个队列
 */
public class TwoStackImplQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /*
     * 队列的数据压入过程
     */
    public void push(Integer element) {
        stack1.push(element);
    }

    /*
     * 队列的数据弹出过程
     */
    public Integer pop() {
        if (stack2.size() <= 0) {    //第二个栈为空
            while (stack1.size() > 0) {    //第一个栈不为空
                stack2.push(stack1.pop());    //将其第一个栈的数据压入第二个栈中
            }
        }
        if (stack2.isEmpty()) {
            try {
                throw new Exception("queue is empty");
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        Integer head = stack2.pop();
        return head;
    }

    public static void main(String[] args) {
        TwoStackImplQueue sq = new TwoStackImplQueue();
        sq.push(1);
        sq.push(3);
        sq.push(5);
        sq.push(4);
        sq.push(2);

        System.out.println(sq.pop());
        System.out.println(sq.pop());

        sq.push(7);
        System.out.println(sq.pop());
    }
}




