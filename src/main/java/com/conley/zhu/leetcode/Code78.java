package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code78 {
    /**
     * 还有一种的树的方法，选和不选为两个分支
     */
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> subRes = new ArrayList<>();
            subRes.add(nums[i]);
            res.add(subRes);
            recursion(i + 1,nums,res);
            list.addAll(res);
        }
        list.add(new ArrayList<>());
        return list;
    }

    public void recursion(int curr,int[] nums, List<List<Integer>> res){
        if(curr > nums.length - 1)return;
        /**
         * 1
         * 12
         * 13
         * 123
         * 这个递归的逻辑比较巧妙，不停遍历结果集，把后面的每一个加上去
         */
        int size = res.size();
        for(int i = 0;i<size;i++){
            List<Integer> subRes = res.get(i);
            List<Integer> subList = new ArrayList<>();
            subList.addAll(subRes);
            subList.add(nums[curr]);
            res.add(subList);
        }
        recursion(++curr,nums,res);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        subRes.add(1);
        res.add(subRes);
        System.out.println(new Code78().subsets(nums));
    }

}
