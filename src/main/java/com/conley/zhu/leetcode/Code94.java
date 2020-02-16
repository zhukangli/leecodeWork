package com.conley.zhu.leetcode;
import java.util.ArrayList;
import java.util.List;

public class Code94 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //中序  左中右
        inorderTravel(root);
        return list;
    }

    public void inorderTravel(TreeNode root){
        if(root == null){
            return ;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }

}
