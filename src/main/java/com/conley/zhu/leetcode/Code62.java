package com.conley.zhu.leetcode;

public class Code62 {
    /**
     *  经典动态规划题目
     */
    public int uniquePaths(int m, int n) {
        //转移方程
        int [][] dp = new int[m][n];
        dp[0][0] = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                //dp[2][1] = dp[1][1] + dp[2][0]
                //dp[1][1] = d
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        //System.out.println(new Code62().uniquePaths(3,2));
        //System.out.println(new Code62().uniquePaths(7,3));
        System.out.println(new Code62().uniquePaths(1,2));
    }

}
