package com.conley.zhu.leetcode;

import java.util.*;

enum Index{
    GOOD,BAD,UNKNOWN;
}

public class Code55 {
    //[2,0]
    /**
     * 我自己写的这个方法居然超时了，是对的了
     */
    Queue<Integer> queue = new LinkedList<>();
    public boolean canJump(int[] nums) {
        queue.add(nums.length - 1);
        int qSize = queue.size();
        while (!queue.isEmpty()) {
            for(int q = 0;q<qSize;q++){
                int index = queue.poll();
                if(index == 0){
                    return true;
                }
                for (int j = index - 1; j >= 0; j--) {
                    if (index - j <= nums[j]) {
                        queue.add(j);
                    }
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums){
        return canJumpPosition(0,nums);
    }

    public boolean canJump3(int[] nums){
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    /**
     *  回溯法
     */
    public boolean canJumpPosition(int position,int[] nums) {
        if(position == nums.length - 1){
            return true;
        }
        int furthestJump = Math.min(position + nums[position],nums.length - 1);
        for(int i = position + 1;i <= furthestJump;i++){
            if(canJumpPosition(i,nums)){
                return true;
            }
        }
        return false;
    }

    /**
     * 自顶而下的动态规划
     */
    Index[] memo;
    public boolean canJumpFromPosition(int position, int[] nums) {
        if(memo[position] != Index.UNKNOWN){
            return memo[position] == Index.GOOD ? true :false;
        }
        int furthestJump = Math.min(position + nums[position],nums.length - 1);
        for(int i = position;i<=furthestJump;i++){
            if(canJumpPosition(i,nums)){
                memo[i] = Index.GOOD;
                return true;
            }else{
                memo[i] = Index.BAD;
                return false;
            }
        }
        return false;
    }

    /**
     * 自底向上的动态规划
     * 可以免去递归的栈开销，并且是从后面算起，遍历到前面的时候，数组已经是计算好了
     */
    public boolean canJump4(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        for(int i = nums.length - 2;i>=0;i--){
            int furthestJump = Math.min(i + nums[i],nums.length - 1);
            for(int j = i + 1;j<=furthestJump;j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    /**
     * 贪心算法
     *  就是每次都去最远的地方，表示前面的所有节点都是可以到达的
     */
    public boolean canJump5(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > max){
                return false;
            }
            max = Math.max(max,i + nums[i]);
        }
        return max >= nums.length - 1;
    }

}
