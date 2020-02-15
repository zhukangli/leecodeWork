package com.conley.zhu.leetcode;

public class Code75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] == 0)red++;
            if(nums[i] == 1)white++;
            if(nums[i] == 2)blue++;
        }
        for(int i = 0 ;i<nums.length;i++){
            if(i < red)nums[i] = 0;
            if(i >= red && i < red + white)nums[i] = 1;
            if(i >= red + white && i < red + white + blue)nums[i] = 2;
        }
    }
}
