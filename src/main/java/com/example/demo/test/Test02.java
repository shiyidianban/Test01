package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test02 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String pre1 = scanner.nextLine();
        String order1 = scanner.nextLine();
        String[] pre2 = pre1.split(" ");
        String[] order2 = order1.split(" ");
        int pre[] = new int[pre2.length];
        int order[] = new int[pre2.length];
        int post[] = new int[pre2.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = Integer.valueOf(pre2[i]);
            order[i] = Integer.valueOf(order2[i]);
        }

        scanner.close();
        TreeNode node = reConstructBinaryTree(pre, order);
        TreeNode node2 = new TreeNode(0);
        node2 = postOrder(node, node2);
        orderTraversal(node2);

        for (int i = 0; i < list.size(); i++) {
            post[i] = list.get(i);

        }

        for (int i = 0; i < post.length; i++) {
            System.out.print(post[i]);
            if (i != post.length - 1)
                System.out.print(" ");

        }

    }

    //根据前序和中序得出二叉树
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    public static void orderTraversal(TreeNode node) {  //中序遍历
        if (node.left != null) {
            orderTraversal(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            orderTraversal(node.right);
        }
    }

    public static TreeNode postOrder(TreeNode node, TreeNode node2) {
        if (node != null) {
            node2 = new TreeNode(0);
            node2.left = postOrder(node.left, node2.left);
            node2.right = postOrder(node.right, node2.right);
            if (node.left != null && node.right != null && node2.right != null && node2.left != null) {
                node2.val = node.left.val + node.right.val + node2.right.val + node2.left.val;
                return node2;
            } else if (node.left != null && node.right != null) {
                node2.val = node.left.val + node.right.val;
                return node2;
            } else {
                return new TreeNode(0);
            }
        } else {
            return new TreeNode(0);
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
