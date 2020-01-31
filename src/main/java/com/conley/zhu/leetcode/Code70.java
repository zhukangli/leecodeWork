package com.conley.zhu.leetcode;

public class Code70 {
    /**
     *  用dfs会超时
     */
    public int climbStairs(int n) {
        dfs(n);
        return count;
    }

    /**
     *  动态规划 dp[i] = dp[i-1] + dp[i-2]
     *  其实是个斐波那契数列
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    int count = 0;

    private void dfs(int targetSum){
        if(targetSum < 0){
            return;
        }
        if(0 == targetSum){
            count++;
            return;
        }
        dfs(targetSum - 1);
        dfs(targetSum - 2);
    }


    public static void main(String[] args) {
        /*System.out.println(new Code70().climbStairs(2));
        System.out.println(new Code70().climbStairs(3));
        System.out.println(new Code70().climbStairs2(2));*/
        System.out.println(new Code70().climbStairs2(4));
    }
}
