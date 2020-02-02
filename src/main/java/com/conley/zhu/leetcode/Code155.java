package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code155 {
    List<Integer> list;
    /** initialize your data structure here. */
    public Code155() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = list.get(0);
        for(int i = 1 ;i<list.size();i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }
}
