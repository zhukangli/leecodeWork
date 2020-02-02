package com.conley.zhu.leetcode;

public class Code160 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /**
     *  这个是对的，但是居然超时了
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA1 = headA;
        ListNode headB1 = headB;
        while(headA1 != null && headB1 != null){
            if(headA1 == headB1){
                return headA1;
            }
            headA1 = headA1== null ? headB:headA1.next;
            headB1 = headB1==null ? headA:headB1.next;
        }
        return null;
    }
}
