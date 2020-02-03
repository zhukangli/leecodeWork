package com.conley.zhu.leetcode;

public class Code206 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 这个我写的，居然调了挺久
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //1->2->3->4->5->NULL
        /**
         * null<-1 2->3->4->5->NULL
         * null<-1<-2 3->4->5->NULL
         *
         *
         */
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        head.next = null;
        ListNode prev = head;
        head = temp;
        while (head != null){
            temp = head.next;
            if(temp == null){
                head.next = prev;
                return head;
            }
            head.next = prev;
            prev = head;
            head = temp;
        }
        return head;
    }

    /**
     * 人家写的多简单
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        //1->2->3->4->5->NULL
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(new Code206().reverseList(n1));
    }



}
