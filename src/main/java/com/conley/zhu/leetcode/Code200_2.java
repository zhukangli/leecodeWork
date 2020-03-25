package com.conley.zhu.leetcode;

import java.util.Arrays;

/**
 * 用一下并查集来做这道题
 * 思路就是合并在一起的集合，然后数集合数量
 */
public class Code200_2 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)return 0;
        int x = grid.length;
        int y = grid[0].length;
        int[] nums = new int[x * y];
        Arrays.fill(nums,-1);
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                if(grid[i][j] == '1'){
                    //这个根本不要
                    //grid[i][j] = '0';
                    //下方有
                    if(i< (x - 1) && grid[i+1][j] == '1'){
                        union(nums,i * y +j,(i+1)*y+j);
                    }
                    //右边有
                    if(j < (y-1) && grid[i][j+1] == '1'){
                        union(nums,i * y +j,i*y+j + 1);
                    }
                }else{
                    nums[i*y+j] = -2;
                }
            }
        }
        int count = 0;
        for(int k = 0;k<nums.length;k++){
            if(nums[k] == -1)count++;
        }
        return count;
    }

    private void union(int[] parents,int x,int y){
        int xRoot = find(parents,x);
        int yRoot = find(parents,y);
        if(xRoot != yRoot){
            parents[xRoot] = yRoot;
        }
    }

    private int find(int[] parents,int i){
        //i的父集是-1，说明就是根了
        if(parents[i] == -1){
            return i;
        }
        return find(parents,parents[i]);
    }
}
