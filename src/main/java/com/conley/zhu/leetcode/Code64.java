package com.conley.zhu.leetcode;

public class Code64 {
    /**
     * 经典的DP题
     */
    public int minPathSum(int[][] grid) {
       int[][] dp = new int[grid.length][grid[0].length];
       for(int i = grid.length - 1;i>=0;i--){
           for(int j  = grid[0].length - 1;j>=0;j--){
               if(i == grid.length - 1 && j != grid[0].length - 1){
                   //横向移动
                   dp[i][j] = grid[i][j] + dp[i][j+1];
               }else if(i != grid.length - 1 && j == grid[0].length - 1){
                   //纵向移动
                    dp[i][j] = grid[i][j] + dp[i+1][j];
               }else if(i != grid.length - 1 && j != grid[0].length - 1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
               }else{
                    dp[i][j] = grid[i][j];
               }
           }
       }
        return dp[0][0];
    }



}
