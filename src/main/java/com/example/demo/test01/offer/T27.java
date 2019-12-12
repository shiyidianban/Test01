package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午7:53:41
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
 */
public class T27 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastlist = covertNode(pRootOfTree, null);
        TreeNode pHead = lastlist;
        while (pHead != null && pHead.left != null) {
            pHead = pHead.left;
        }
        return pHead;
    }

    public TreeNode covertNode(TreeNode root, TreeNode lastlist) {
        if (root == null)
            return null;
        TreeNode cur = root;
        if (cur.left != null) {
            lastlist = covertNode(cur.left, lastlist);
        }
        cur.left = lastlist;
        if (lastlist != null) {
            lastlist.right = cur;
        }
        lastlist = cur;
        if (cur.right != null) {
            lastlist = covertNode(cur.right, lastlist);
        }
        return lastlist;
    }
}
