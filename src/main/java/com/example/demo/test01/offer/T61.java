package com.example.demo.test01.offer;

import java.util.ArrayList;
import java.util.LinkedList;


public class T61 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            start++;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}
