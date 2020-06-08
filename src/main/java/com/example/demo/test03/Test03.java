package com.example.demo.test03;

public class Test03 {

    public static Boolean isValidBST(TreeNode root){

        if (root.left != null && root.right != null){
            if (root.left.val < root.val && root.right.val > root.val){
                return isValidBST(root.left) && isValidBST(root.right);
            }else{
                return false;
            }
        }

        if (root.left != null){
            if (root.left.val < root.val){
                return isValidBST(root.left);
            }else{
                return false;
            }
        }

        if (root.right != null){
            if (root.right.val > root.val){
                return isValidBST(root.right);
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));
    }

}

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val){
        this.val = val;
    }
}
