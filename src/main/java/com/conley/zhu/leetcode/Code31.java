package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class Code31 {
    /**
     *  这个是错的，一些细节我懒得去想了，基本的思路有了
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return;
        }
        int range = 1;
        while (range < length){
            for (int i = 0; i < range; i++) {
                int front = nums[length - 2 - i];
                int rear = nums[length - 1 - i];
                if (front < rear) {
                    nums[length - 2 - i] = rear;
                    nums[length - 1 - i] = front;
                    return;
                }
            }
            range++;
        }

    }

    /**
     *  这个是我抄人家的
     */
    public void nextPermutation2(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            } else {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, len);
                    for (int j = i; j <len; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return;
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        /**
         * 4 5 6 5 4  ->  4 6 5 5 4
         */
        int[] nums = new int[]{4,5,6,5,4};
        new Code31().nextPermutation(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }

}
