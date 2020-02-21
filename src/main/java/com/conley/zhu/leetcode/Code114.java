package com.conley.zhu.leetcode;

public class Code114 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 后续遍历，把后一个的右指针指向前一个
     * @param root
     */
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        //这一步很重要，要把左边的去掉，因为是从后面遍历，不用担心改变子节点，因为后面的已经处理了，再指向后面节点没有意义了
        root.left = null;
        prev = root;
    }
}
