package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

public class Code34 {
    /**
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 这个代码我抄得，别人写的清晰明了
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = findFirst(nums, target);
        ret[1] = findLast(nums, target);
        return ret;
    }

    private int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == nums.length - 1) || (nums[mid + 1] != target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (nums[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums4 = new int[]{5,7,7,8,8,10};
        System.out.println(JSONObject.toJSONString(new Code34().searchRange(nums4,8)));
    }
}
