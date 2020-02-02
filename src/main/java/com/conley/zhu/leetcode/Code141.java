package com.conley.zhu.leetcode;

public class Code141 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode head1 = head;
        while (head != head1){
            if(head1 == null){
                return false;
            }

            head = head.next;
            if(head1.next == null || head1.next.next == null){
                return false;
            }
            head1 = head1.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        System.out.println(new Code141().hasCycle(n1));
    }
}
