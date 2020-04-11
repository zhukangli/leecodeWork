package com.conley.zhu.leetcode;

/**
 * 手机上看了下思路，完全是自己做出来的，不错不错
 */
public class Code221 {
    private int charToInt(char a){
        if(a == '1')return 1;
        return 0;
    }
    /**
     * 动态规划题
     *  dp[i][j] 表示坐标（i，j）最大边长
     *  dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + 1;
     *
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)return 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int [][] dp = new int[x][y];
        int max = 0;
        for(int k = 0;k<x;k++){
            dp[k][0] = charToInt(matrix[k][0]);
            if(dp[k][0] > max)max = dp[k][0];
        }
        for(int k = 0;k<y;k++){
            dp[0][k] = charToInt(matrix[0][k]);
            if(dp[0][k] > max)max = dp[0][k];
        }
        for(int i = 1;i<x;i++){
            for(int j = 1;j<y;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max)max = dp[i][j];
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[3][4];
        char[] row1 = new char[]{'1','1','1','1'};
        char[] row2 = new char[]{'1','1','1','1'};
        char[] row3 = new char[]{'1','1','1','1'};
        matrix[0] = row1;
        matrix[1] = row2;
        matrix[2] = row3;
        System.out.println(new Code221().maximalSquare(matrix));
    }



}
