package com.conley.zhu.leetcode;

public class Code279 {
    /**
     *  动态规划 dp[i]表示i可以表示为多少个完全平方数
     *  考虑数字12
     *      1）12 - 1 =11，去考虑11要多少完全平方数表示，然后 + 1就是dp[12]的值
     *      2）12 - 4 =8，去考虑8要多少完全平方数表示 + 1，然后 + 1就是dp[12]的值
     *      3）12 - 9 =3，去考虑3要多少完全平方数表示 + 1，然后 + 1就是dp[12]的值
     *      综合上面的几个值取最小值
     */
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        //从1-n，算出这些数可以表示完全平方数的个数
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            int val = Integer.MAX_VALUE;
            for(int j = 1;j * j <= i;j++){
                val = Math.min(val,dp[i - j*j] + 1);
            }
            dp[i] =val;
        }
        return dp[n];
    }

}
