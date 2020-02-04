package com.conley.zhu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code461 {
    /**
     * 这个异或操作前面有题做过，这我轻松做出了
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while(z != 0){
            if(z % 2 > 0){
                count++;
            }
            z = z / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code461().hammingDistance(1,4));
    }
}
