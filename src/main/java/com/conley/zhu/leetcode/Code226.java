package com.conley.zhu.leetcode;

public class Code226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 这个我5min轻松写出
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
