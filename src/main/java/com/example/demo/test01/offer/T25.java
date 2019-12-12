package com.example.demo.test01.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wu161 2018年8月26日下午7:53:41
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
 */
public class T25 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return resultList;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        } else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        // 每返回上一层一次就要回退一个节点
        list.remove(list.size() - 1);
        return resultList;
    }
}
