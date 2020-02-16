package com.conley.zhu.leetcode;

/**
 * 因为我对这个邻接表的使用还不是很熟悉，我就直接抄一下，理解清楚就好，下一题再争取自己写出来
 */
public class Code79 {
    private boolean[][] marked;
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
    //m行
    private int m;
    //n列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if(m == 0)return false;
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        //遍历每个位置
        for(int i = 0 ;i<m;i++){
            for(int j = 0;j<n;j++){
                //深度优先搜索能找到，就返回true
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(int i,int j,int start){
        if(start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){
            //标记为已访问
            marked[i][j] = true;
            //对该结点的每个邻接点，进行递归遍历
            for(int k =0;k<4;k++){
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                //这两个点存在，且没有被访问过，就去访问之
                if(inArea(newX,newY) && !marked[newX][newY]){
                    //这里居然++start不行
                    if(dfs(newX,newY,start + 1)){
                        return true;
                    }
                }
            }
            //递归后清除访问痕迹很重要
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
