package com.conley.zhu.leetcode;


public class Code101 {
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }


    /**
     * 这个答案的递归写的真6
     * @param t1
     * @param t2
     * @return
     */
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);

    }

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
