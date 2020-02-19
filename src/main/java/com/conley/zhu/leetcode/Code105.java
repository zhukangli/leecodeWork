package com.conley.zhu.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Code105 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    /**
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    /**
     * 思路：前序找根，去中序得到左右子树
     *       根据左子树去前序，找到左子树的根，和右子树的根
     *       直到所有数被遍历
     */


    int pre_idx = 0;
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int left,int right){
        //前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]
        if(left == right){
            return null;
        }
        int root_val = preOrder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        //根节点的中序
        int idx = idx_map.get(root_val);

        pre_idx++;
        //这里就很巧妙了，要仔细体会，递归地去利用前序创建TreeNode去处理完中序里面的数字
        root.left = helper(left,idx);
        root.right = helper(idx + 1,right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        int idx = 0;
        for(int val : inorder){
            idx_map.put(val,idx++);
        }
        return helper(0,inorder.length);
    }
}
