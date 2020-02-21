package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个思路：中序遍历二叉树，遍历结果如果按照从小到大的顺序排列，则表明是二叉搜索树，否则不是二叉搜索树。
 * 这个思路真是牛逼，一下就AC了
 * 递归解法有点难，我一下没搞懂，就没去管了
 *
 */
public class Code98 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrderTravel(root);
        if(list.size() > 0){
            for(int i = 0;i<list.size();i++){
                if(i > 0 && i <= list.size() - 1){
                    if(list.get(i) <= list.get(i - 1)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void inOrderTravel(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTravel(root.left);
        list.add(root.val);
        inOrderTravel(root.right);
    }
}
