package com.conley.zhu.leetcode;

public class Code136 {
    /**
     * 这个异或厉害了
     * 意思就是两个位（位运算，比较的是二进制的位）是否相等，不相等是1，相等是0
     *  0 和 任何数 异或得到任何数
     *  公式：a xor a xor b = b
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
