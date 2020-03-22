package com.conley.zhu.leetcode;

public class Code152 {
    /**
     *  首先想的就是穷举各种情况 负数为偶数，负数为基数，含0等情况
     *  其次想的是构造一颗树，穷举所有路径（这个行不通）
     */

    /**
     *  max[i] 表示以第i个数结尾的最大乘积值
     *  min[i] 表示以第i个数结尾的最小乘积值
     *  num[i] >= 0 时候
     *      max[i] = Math.max(num[i],num[i] * max[i - 1]);
     *      min[i] = Math.min(num[i],num[i] * min[i - 1]);
     *  num[i] < 0 时候
     *      max[i] = Math.max(num[i],num[i] * min[i - 1]);
     *      min[i] = Math.min(num[i],num[i] * max[i - 1]);
     *
     *  结果就是 Math.max(首个值，max[i]);
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 1)return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int ret = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] >= 0){
                max[i] = Math.max(nums[i],nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i],nums[i] * min[i - 1]);
            }else{
                max[i] = Math.max(nums[i],nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i],nums[i] * max[i - 1]);
            }
            ret = Math.max(ret,max[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Code152().maxProduct(new int[]{2,3,-2,4}));
    }

}
