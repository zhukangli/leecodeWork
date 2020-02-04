package com.conley.zhu.leetcode;

public class Code437 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    /**
        对所有的子树，统计其所有的和为sum路径
     */
    public int pathSum(TreeNode root, int sum) {
        return path(root,sum,0);
    }

    public int path(TreeNode root, int sum,int res){
        if (root == null){
            return res;
        }
        if(sum == root.val){
            return  ++res;
        }
        res += path(root.left,sum - root.val,res);
        res += path(root.right,sum - root.val,res);
        return res;
    }


}
