package com.conley.zhu.leetcode;

public class Code53 {
    //这个比较简单，就是遍历到的数比之前的和还大，就把前面的丢掉
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for(int num:nums){
            sum += num;
            if(num > sum){
                sum = num;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
