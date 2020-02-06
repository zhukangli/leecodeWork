package com.conley.zhu.leetcode;

public class Code112 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null){
            return true;
        }
        boolean leftPath = hasPathSum(root.left,sum - root.val);
        boolean rightPath =hasPathSum(root.right,sum - root.val);
        return leftPath || rightPath;
    }

}
