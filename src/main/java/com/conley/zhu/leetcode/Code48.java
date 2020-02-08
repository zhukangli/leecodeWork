package com.conley.zhu.leetcode;

/**
 * 先前后替换行
 * 然后转置一下
 * 这样就可以达到旋转的目的
 */
public class Code48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0 ;i < (length + 1)/2 ;i++){
            for(int j = 0 ;j < length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        }


        for(int i = 0 ;i<length;i++){
            for(int j = i;j<length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
