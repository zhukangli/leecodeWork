package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index - 1] > 0){
                nums[index - 1] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new Code448().findDisappearedNumbers(nums));
    }
}
