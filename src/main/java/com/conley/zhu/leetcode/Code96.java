package com.conley.zhu.leetcode;

public class Code96 {
    /**
     * 这题还真是难了,我觉得这道题只能背下来了
     */
    public int numTrees(int n) {
        //G数组表示多少个不同的二叉搜索树
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
