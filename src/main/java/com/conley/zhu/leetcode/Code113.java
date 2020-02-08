package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Code113 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> list = new ArrayList<>();
    List sublist = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root,sum);
        return list;

    }

    public void path(TreeNode root, int sum){
        if(root == null){
            return;
        }
        sublist.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            //这里一定要new一个，不然subList会全部remove掉
            list.add(new ArrayList<>(sublist));
        }
        path(root.left,sum - root.val);
        path(root.right,sum - root.val);
        sublist.remove(sublist.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left=n2;n1.right=n3;
        n2.left=n4;
        n3.left=n5;n3.right=n6;
        n4.left=n7;n4.right=n8;
        n6.left=n9;n6.right=n10;
        System.out.println(JSONObject.toJSONString(new Code113().pathSum(n1,22)));

    }
}
