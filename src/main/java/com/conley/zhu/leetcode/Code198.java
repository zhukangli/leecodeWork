package com.conley.zhu.leetcode;

public class Code198 {
    /**
     *  这个本质也是动态规划
     */
    public int rob1(int[] nums) {
        int even = 0 ;
        int odd = 0;
        //1,3,1,3,100
        for(int i = 0 ;i<nums.length;i++){
            if(i % 2 == 0){
                even += nums[i];
                //这里的意思是取前面这一段的最大值，这样想就很容易理解了
                even = Math.max(even,odd);
            }else{
                odd += nums[i];
                odd = Math.max(even,odd);
            }
        }
        return Math.max(even,odd);
    }


    /**
     *  写一个动态规划版本
     *   写完这里对DP有了初步认识，所谓状态转移方程就是一个递推关系式
     */
    public int rob2(int[] nums) {
        if(nums.length == 0){
            return 0 ;
        }else if(nums.length == 1){
            return nums[0] ;
        }else if(nums.length == 2){
            return Math.max( nums[0] , nums[1] );
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0] ;
        dp[1] = Math.max( nums[0] , nums[1] );
        for(int i = 2 ;i<nums.length;i++){
            dp[i] =  Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length - 1];
    }



}
