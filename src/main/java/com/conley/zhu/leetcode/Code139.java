package com.conley.zhu.leetcode;

import java.util.List;

public class Code139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak2(s,wordDict,0,new Boolean[s.length()]);
    }

    /**
     * 先要看懂暴力法
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict, int start){
        //表示遍历完了
        if(start == s.length()){
            return true;
        }
        //考虑aaaaa的情况，就知道为什么要剪枝了
        for(int end = start + 1;end<=s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && wordBreak(s,wordDict,end)){
                return true;
            }
        }
        return false;
    }


    /**
     *  回溯剪枝思路：遍历s，i-j命中后，再去递归查j之后的是否能命中
     *  memo记录的是i开头的是否命中
     *  我这猪脑袋，自己做肯定是做不出的
     */
    public boolean wordBreak2(String s, List<String> wordDict,int start,Boolean[] memo){
        //表示遍历完了
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for(int end = start + 1;end<=s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && wordBreak2(s,wordDict,end,memo)){
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    /**
     * 宽度优先搜索
     */



    /**
     * 动态规划思路
     */
    public boolean wordBreak3(String s, List<String> wordDict,int start,Boolean[] memo){


        return true;
    }

}
