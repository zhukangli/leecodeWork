package com.conley.zhu.leetcode;

public class Code581 {
    /**
     * 思路：
     * 1、先找到第一个逆序的最小值
     * 2、找到第一个逆序的最大值
     * 3、遍历，看下第一个大于最小值的在哪里
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        //[2, 6, 4, 8, 10, 9, 15]
        //[1,2,3,3,3]
        //[1,3,3,3,2,2,2]
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3};
        System.out.println(new Code581().findUnsortedSubarray(nums));
    }
}
