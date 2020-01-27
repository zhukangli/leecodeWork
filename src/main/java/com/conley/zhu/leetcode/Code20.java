package com.conley.zhu.leetcode;

import java.util.Stack;

public class Code20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i < s.length();i++){
            Character c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            Character top = stack.peek();
            if(!isRight(top,c)) {
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isRight(Character stackC,Character c){
        if('(' == stackC && ')' == c){
            return true;
        }
        if('[' == stackC && ']' == c){
            return true;
        }
        if('{' == stackC && '}' == c){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().isValid("{}()[]"));
        System.out.println(new Code20().isValid("{[]}"));
    }

}
