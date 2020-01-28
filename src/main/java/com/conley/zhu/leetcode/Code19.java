package com.conley.zhu.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Code19 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //双指针法可以实现一次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1->2->3->4->5
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode temp = p;
        ListNode prev = p;
        ListNode rear = p;
        for(int i = 0;i <= n;i++){
            rear = p.next;
            p = p.next;
        }
        while (rear != null){
            prev = prev.next;
            rear = rear.next;
        }
        prev.next = prev.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(JSONObject.toJSONString(new Code19().removeNthFromEnd(node1,2)));
    }

}
