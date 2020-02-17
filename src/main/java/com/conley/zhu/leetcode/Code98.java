package com.conley.zhu.leetcode;

public class Code98 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    TreeNode parent;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val >= root.val){
            return false;
        }
        if(root.right != null && root.right.val <= root.val){
            return false;
        }
        if(isValidBST(root.left) && isValidBST(root.right)){
            return true;
        }
        return true;
    }

    public boolean isValid(TreeNode root,TreeNode upper){
        if(root == null)return true;
        if(root.left != null && root.left.val >= root.val ||
                root.right != null && root.right.val <= root.val){
            return false;
        }
        if(upper != null &&  root.right != null && upper.val < root.right.val){
            return false;
        }
        return false;
    }
}
