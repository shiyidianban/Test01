package com.example.demo.test;

public class Test18 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = Test18.reverseList(head);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        while (head.next != null){
            ListNode n = reverseList(head.next);
            head.next = head.next.next;
            n.next = head;
            head = n;
        }

        return head;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}