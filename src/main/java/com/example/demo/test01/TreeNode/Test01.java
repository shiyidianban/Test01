package com.example.demo.test01.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wu161 2018年9月12日下午2:16:09
 */
public class Test01 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 前序遍历，递归实现
     * */
    public void PreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val);
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    /*
     * 前序遍历，非递归实现
     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     * */
    public void PreOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            //右结点先入栈，左结点后入栈
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    /*
     * 中序遍历，递归实现
     * */
    public void InOrder(TreeNode node) {
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.val);
            InOrder(node.right);
        }
    }

    /*
     中序遍历，非递归实现
     1，首先从根节点出发一路向左，入栈所有的左节点；
     2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
     若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
     3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
     4，直到节点为null，且栈为空。
     */
    public void InOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val);
                root = node.right;
            }
        }
    }

    /*
     * 后序遍历，递归实现
     * */
    public void PostOrder(TreeNode node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.val);
        }
    }

    /*
     * 层序遍历（广度优先遍历）
     * */
    public void LayerOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
