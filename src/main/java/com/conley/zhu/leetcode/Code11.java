package com.conley.zhu.leetcode;

/**
 * 盛最多水的容器
 */
public class Code11 {
    /**
     *  这个的思路在于保留长边，短边往长边靠，去找最大可能值
     */
    public int maxArea(int[] height) {
        int length = height.length;
        if(length == 0){
            return 0;
        }
        int frontIndex = 0;
        int rearIndex = length - 1;
        int front = height[frontIndex];
        int rear = height[rearIndex];
        int result = 0;
        while(frontIndex != rearIndex){
            if(front > rear){
                int temp = rear * (rearIndex - frontIndex);
                result = result > temp ? result : temp;
                rear =  height[--rearIndex];
            }else{
                int temp = front * (rearIndex - frontIndex);
                result = result > temp ? result : temp;
                front =  height[++frontIndex];
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        System.out.println(new Code11().maxArea(height));
    }

}
