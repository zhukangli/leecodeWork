package com.conley.zhu.leetcode;

import com.sun.tools.javac.jvm.Code;

import java.util.LinkedList;
import java.util.Queue;

public class Code543 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(5);
        TreeNode a1 = new TreeNode(0);
        TreeNode a2 = new TreeNode(-1);
        TreeNode a3 = new TreeNode(-6);
        TreeNode a4 = new TreeNode(7);
        TreeNode a5 = new TreeNode(1);
        TreeNode a6 = new TreeNode(3);
        TreeNode a7 = new TreeNode(9);
        TreeNode a8 = new TreeNode(6);
        TreeNode a9 = new TreeNode(0);
        TreeNode c1 = new TreeNode(-4);
        TreeNode c2 = new TreeNode(-9);
        TreeNode c3 = new TreeNode(0);
        TreeNode c4 = new TreeNode(-7);
        TreeNode c5 = new TreeNode(-4);
        TreeNode c6 = new TreeNode(1);
        TreeNode c7 = new TreeNode(-4);
        b.left = a1;b.right=c1;
        a1.left = a2;a1.right=a3;
        a2.left=a4;a3.left=a5;a3.right=a6;
        a4.right=a7;a6.left=a8;a6.right=a9;

        c1.left=c2;
        c2.right=c3;
        c3.right=c4;
        c4.left=c5;
        c5.left=c6;
        c6.right=c7;
        System.out.println(new Code543().diameterOfBinaryTree(b));

    }
}
