package com.conley.zhu.leetcode;

public class Code121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int max = prices[0];
        int min = prices[0];
        int ans = max - min;
        int index = 0;
        for(int i = 0 ;i<prices.length;i++){
            //2,4,1,2
            if(prices[i] < min){
                max = prices[i];
                min = prices[i];
                index = i;
            }
            if(prices[i] > max && i > index){
                max = prices[i];
            }
            ans = Math.max(max -min,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(new Code121().maxProfit(nums));
    }
}
