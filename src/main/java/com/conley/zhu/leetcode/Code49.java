package com.conley.zhu.leetcode;

import java.util.*;

public class Code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String str = strs[i];
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            String key ="";
            for(int j = 0;j<charStr.length;j++){
                key += charStr[j];
            }
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List subList = new ArrayList();
                subList.add(str);
                map.put(key,subList);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(List<String > subList:map.values()){
            list.add(subList);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Code49().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
