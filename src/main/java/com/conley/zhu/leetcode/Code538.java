package com.conley.zhu.leetcode;

public class Code538 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private int sum = 0;

    /**
     * 这个就是树的反序中序遍历
     * 关键要理解最后要回到root这一点比较难，其实这也是回溯的基本题目
     */

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


}
