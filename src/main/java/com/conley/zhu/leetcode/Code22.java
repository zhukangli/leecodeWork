package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Code22 {
    /**
     *  我用了深度优先算法，遍历树拿叶节点，不理解的话画个图很容易就明白了
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0){
            return list;
        }
        dfs(n,n,"",list);
        return list;
    }

    /**
     *  这里的话是动态规划，不是自己写的，是我复制的，还不是特别理解，后面再来看吧
     */
    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public void dfs(int left,int right,String currStr,List<String> res){
        if(left == 0 && right == 0){
            res.add(currStr);
            return;
        }
        //这里剪枝
        if(left < 0 || left > right) return;
        dfs(left - 1,right,currStr + "(",res);
        dfs(left,right - 1,currStr + ")",res);
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Code22().generateParenthesis(2)));
    }

}
