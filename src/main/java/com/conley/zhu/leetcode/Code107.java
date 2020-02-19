package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code107 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if(root == null)return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            list.addFirst(subList);
        }
        return list;
    }
}
