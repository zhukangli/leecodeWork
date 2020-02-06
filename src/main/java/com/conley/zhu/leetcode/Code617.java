package com.conley.zhu.leetcode;

public class Code617 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     *  我写的狗屎一样，没有考虑返回值要赋给上一层，导致调了很久 
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if(t1 == null && t2 == null){
            return node;
        }
        if(t1 == null && t2 != null){
            node = t2;
            node.left = mergeTrees(null,node.left);
            node.right = mergeTrees(null,node.right);
        }else if(t1 != null && t2 == null){
            node = t1;
            node.left = mergeTrees(node.left,null);
            node.right =  mergeTrees(node.right,null);
        }else{
            node = t1;
            node.val += t2.val;
            node.left = mergeTrees(t1.left,t2.left);
            node.right = mergeTrees(t1.right,t2.right);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(5);
        a1.left =a2;
        a2.left=a4;
        a1.right=a3;

        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(1);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(7);
        b1.left=b2;
        b1.right=b3;
        b2.right=b4;
        b3.right=b5;
        System.out.println(new Code617().mergeTrees(a1,b1));
    }
}
