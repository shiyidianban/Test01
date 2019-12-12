package com.example.demo.test01.offer;

import java.util.Stack;

/**
 * @author wu161 2018年8月26日下午7:50:39
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 * 使用递归或非递归方式交换每个节点的左右子树位置。
 */
public class T19 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
