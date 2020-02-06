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
        int res = path(root,sum) ;
        if(root != null){
            res += pathSum(root.left,sum);
            res += pathSum(root.right,sum);
        }
        return res;
    }


    public int path(TreeNode root, int sum){
        int res = 0;
        if (root == null){
            return res;
        }
        if(sum == root.val){
            //这里不能return，我就是这里return导致错了，因为还可以继续找下面的路径
            ++res;
        }
        res += path(root.left,sum - root.val);
        res += path(root.right,sum - root.val);
        return res;
    }


}
