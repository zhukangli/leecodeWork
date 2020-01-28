package com.conley.zhu.leetcode;

public class Code33 {
    /**
     输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4

     输入: nums = [4,5,6,7,0,1,2], target = 3
     输出: -1
     我自己写的，屎一样，while里面的条件都没写好
     */
    public int search(int[] nums, int target) {
        int beginIndex = 0;
        int endIndex = nums.length - 1;
        int index = (beginIndex + endIndex) / 2;
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        while (index >= beginIndex && index <= endIndex){
            int mid = nums[index];
            if(mid == target){
                return index;
            }
            if(nums[beginIndex] <= target && target < mid){
                endIndex = index - 1;
            }else{
                if(nums[endIndex] < target){
                    endIndex = index - 1;
                }else{
                    beginIndex = index + 1;
                }
            }
            index = (beginIndex + endIndex) / 2;
        }
        return -1;
    }

    /**
     * 这我抄别人的
     * 所以写代码前最好先写方案
     */
        public int search2(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                //前半部分有序,注意此处用小于等于
                if (nums[start] <= nums[mid]) {
                    //target在前半部分
                    if (target >= nums[start] && target < nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target <= nums[end] && target > nums[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }
            return -1;

        }


    public static void main(String[] args) {
/*       int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Code33().search(nums,3));
        int[] nums2 = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Code33().search(nums2,0));
        int[] nums3 = new int[]{1,3};
        System.out.println(new Code33().search(nums3,0));*/
        int[] nums4 = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(new Code33().search(nums4,8));
    }
}
