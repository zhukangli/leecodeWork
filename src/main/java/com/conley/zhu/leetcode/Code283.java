package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code283 {
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    /**
     * 遍历，遇到第一个非0的数，前面有0，与最前面0交换位置
     *                        前面没有0，不动
     *       遇到0的数，记下index位置
     *
     *  我这个也通过了，网上有更好思路
     *
      */

    public void moveZeroes(int[] nums) {
        Queue<Integer> indexQueue = new LinkedList<>();
        for(int i = 0 ;i<nums.length;i++){
            int ans = nums[i];
            if(ans == 0){
                indexQueue.add(i);
            }else{
                if(!indexQueue.isEmpty()){
                    nums[indexQueue.poll()] = nums[i];
                    nums[i] = 0;
                    indexQueue.add(i);
                }
            }
        }
    }
}
