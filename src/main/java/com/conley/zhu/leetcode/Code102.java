package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 这个层级遍历我轻松通过
 */
public class Code102 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)queue.add(root);
        while (queue.size() > 0){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            list.add(subList);
        }
        return list;
    }

}
