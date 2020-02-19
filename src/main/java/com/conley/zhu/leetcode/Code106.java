package com.conley.zhu.leetcode;

import sun.net.TelnetInputStream;

import java.util.HashMap;
import java.util.Map;

/**
 * 这题跟105题一模一样，稍微有点绕，我基本靠回忆做出来了
 */
public class Code106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int[] inOrder ;
    int[] postorder ;
    int prev = 0;
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postorder = postorder;
        prev = postorder.length - 1;
        for(int i = 0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return helper(0,inorder.length);
    }

    /**
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *
     */
    public TreeNode helper(int left,int right){
        if(left == right){
            return null;
        }
        TreeNode root = new TreeNode(postorder[prev]);
        /*
            这里index弄成一个全局变量，在递归过程会有问题，影响外层变量，而且效率不高
            我在这里栽了坑
        for(int i = 0;i<inOrder.length;i++){
            if(inOrder[i] == root.val){
               index = i;
            }
        }*/
        int index = map.get(root.val);
        prev--;
        //关键就是这里要仔细体会
        root.right = helper(index + 1,right);
        root.left = helper(left,index);
        return root;
    }
}
