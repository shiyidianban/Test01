package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午7:05:10
 *
 * O(1)时间删除链表节点
 */
public class T13 {
    public static void deleteNode(ListNode head, ListNode deListNode) {
		if (deListNode == null || head == null)
			return;
		if (head == deListNode) {
			head = null;
		} else {
			// 若删除节点是末尾节点，往后移一个
            if (deListNode.next == null) {
				ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
				}
                pointListNode.next = null;
			} else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        deleteNode(head, head.next.next);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}
