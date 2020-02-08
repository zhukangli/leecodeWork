package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题完全是自己做出来的，完全没看答案，真心牛逼了
 */
public class Code46 {
    public List<List<Integer>> permute(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            permute(nums[i],nums);
            count = 0;
            subList.clear();
        }
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    //这个count也是后面补上的，总体来说，是先搭架构，后面再补充细节的
    int count = 0;

    public void permute(int n,int[] nums){
        subList.add(n);
        if(subList.size() == nums.length){
            list.add(new ArrayList<>(subList));
            count++;
            return;
        }
        for(int i = 0;i<nums.length;i++){
            //一开始我是count < nums.length,这里是不对的
            if(!subList.contains(nums[i]) && count < getTimes(nums.length)){
                permute(nums[i],nums);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public int getTimes(int n){
        if(n == 0){
            return 1;
        }
        return getTimes(n-1) * n;
    }

    public static void main(String[] args) {
        System.out.println(new Code46().permute(new int[]{1,2,3}));
    }
}
