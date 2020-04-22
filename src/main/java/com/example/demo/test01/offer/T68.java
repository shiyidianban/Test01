package com.example.demo.test01.offer;

/**
 * java实现单链表逆转
 *
 * @author FLY
 * @date 2020-04-22 14:50
 */
public class T68 {

    //单链表
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //翻转方法
    public static ListNode reverse(ListNode head) {
        //指定当前节点的前驱
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        //当前节点的后继
        ListNode next = null;
        //因为这里每次执行后都是将next赋给了cur，所以需要判断cur
        while (cur != null) {
            //保存当前节点的后继
            next = cur.next;
            //将当前节点后继改成前驱，这也是翻转最重要的一步，头结点的后继应该为空
            cur.next = pre;
            //依次向后移动一个单位，执行完成后，pre指的是翻转前最后的节点，也就是翻转后的头结点
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode reverse = reverse(node1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
