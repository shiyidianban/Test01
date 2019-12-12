package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午1:57:59
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：平衡因子的绝对值<= 1.
 */
public class T39_1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int diff = left - right;
        if (diff >= -1 && diff <= 1) {
            return true;
        }
        return false;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        int leftNode = getDepth(root.left);
        int rightNode = getDepth(root.right);
        depth = leftNode > rightNode ? leftNode : rightNode;
        return depth + 1;
    }
}
