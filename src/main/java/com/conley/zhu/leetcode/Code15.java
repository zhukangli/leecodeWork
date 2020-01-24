package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3){
            return list;
        }else if(nums.length == 3){
            if (nums[0] + nums[1] + nums[2] == 0) {
                List resultList = new ArrayList();
                resultList.add(nums[0]);
                resultList.add(nums[1]);
                resultList.add(nums[2]);
                list.add(resultList);
                return list;
            }
        }
        for(int i = 0 ;i< nums.length - 3;i++){
            //这个判断很重要，就是相同的直接跳过
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int resultI = nums[i];
            int front = i + 1;
            int rear = nums.length - 1;
            while(front != rear){
                if(resultI + nums[front] + nums[rear] < 0){
                    front ++;
                }else if(resultI + nums[front] + nums[rear] == 0){
                    List resultList = new ArrayList();
                    resultList.add(resultI);
                    resultList.add(nums[front]);
                    resultList.add(nums[rear]);
                    list.add(resultList);
                    //这个写法牛逼啊,用if实现不了，必须用while，不然会有重复值
                    while (front != rear && nums[front] == nums[++front]);
                    while (front != rear && nums[rear] == nums[--rear]);
                }else {
                    rear --;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> list = new Code15().threeSum(nums);
        System.out.println(JSONObject.toJSONString(list));
    }
}
