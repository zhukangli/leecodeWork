package com.conley.zhu.leetcode;

public class Code236 {
    /**
     *  第一个滑窗  遍历得到最大值
     *  下一个滑窗，等于头部移除，尾部移入一个数字
     *      如果移入 >= 最大值，则更新此滑窗最大值
     *      如果移入 < 最大值，如果移除的头部刚好为最大值，则遍历求最大值
     *                       如果移除的头部不是最大值，那最大值维持
     */
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int windowSize = nums.length - k + 1;
        int[] result = new int[windowSize];
        int max = 0;
        int head = nums[0];
        int tail = nums[k - 1];
        for(int i = 0;i<k;i++){
            if(nums[i] >= max)max = nums[i];
        }
        result[0] = max;
        for(int i = 0;i<windowSize;i++){
            if(nums[i + k - 1] >= max){
                result[i] = nums[i + k - 1];
            }else{
                if(){

                }

            }

        }

    }*/



}
