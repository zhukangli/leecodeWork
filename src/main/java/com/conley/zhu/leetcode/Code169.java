package com.conley.zhu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code169 {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        for(int i = 0;i<size;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) + 1 > size/2){
                    return nums[i];
                }
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        return 0;
    }
}
