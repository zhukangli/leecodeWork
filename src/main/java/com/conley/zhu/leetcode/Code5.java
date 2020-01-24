package com.conley.zhu.leetcode;


/**
 * 给定一a1字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code5 {

    public String commonSubString(String s){
        if(s.length() <= 1){
            return s;
        }
        String s1 = reverse(s);
        int length = s.length();
        int[][] dp = new int[length][length];
        int maxLen = 0;
        int end = 0;
        for(int i = 0;i<length;i++){
            for(int j = 0 ;j<length;j++){
                char c = s.charAt(i);
                char c1 = s1.charAt(j);
                if(i == 0 || j == 0){
                    if(c == c1){
                        dp[i][j] = 1;
                    }
                }else{
                    if(c == c1){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if(dp[i][j] > maxLen){
                    //这里要判断一下abc485cba这种情况,源串s的位置加上长度为i，说明ij这里是回文
                    int before = length - 1 - j;
                    if (before + dp[i][j] -1 == i) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        String result =  s.substring(end - maxLen + 1,end + 1);
        return result;
    }

    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }


    public static void main(String[] args) {
        //1:暴力法

        //2:最长公共子串（动态规划）
        new Code5().commonSubString("aacdefcaa");
        //3:中心拓展法

        //4:马拉车法

    }

}
