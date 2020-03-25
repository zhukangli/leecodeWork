package com.conley.zhu.leetcode;

import java.util.LinkedList;

/**
 * 用BFS解一下
 * 看得出用了队列后，代码还是比较简单的
 */
public class Code200_3 {
    private int rows;
    private int cols;

    public int numIsland(char[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!marked[i][j] && grid[i][j] == '1'){
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.add(i * cols + j);
                    marked[i][j] = true;
                    while (!queue.isEmpty()){
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                marked[newX][newY] = true;
                            }
                        }
                    }

                }
            }
        }
        return count;
    }

    private boolean inArea(int x,int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
