package com.conley.zhu.leetcode;

/**
 * 典型的求连通图的数量
 */
public class Code200_1 {
    //方向数组，四个方向，常见的技巧，之前其实也用过，但是我忘记了
    private static final int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;

    /**
     *  构建邻接矩阵或者邻接表，这里题目已经帮忙构建好临接矩阵
     *
     *
     */
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if(rows == 0){
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for(int i =0 ;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!marked[i][j] && grid[i][j] == '1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i,int j){
        marked[i][j] = true;
        //4个方向
        for(int k = 0;k<4;k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            //这个是否在区域判断很容易漏掉,而且必须放最前面
            if(inArea(newX,newY) && grid[newX][newY] == '1' && !marked[newX][newY]){
                dfs(newX,newY);
            }
        }
    }

    private boolean inArea(int x,int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
