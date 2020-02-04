package com.conley.zhu.leetcode;

public class Code234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 看了一遍答案后我自己写的，太牛逼了
     * 主要就是思路，特别是分成前后两部分的快慢指针法，太牛逼了
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null)return true;
        //链表分成前后两部分
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        ListNode secondBegin = firstHalfEnd.next;
        //把后部分翻转
        ListNode reversedSecondHalf = reverseListNode(secondBegin);
        //比较是否相等
        boolean result = equalsNode(head,reversedSecondHalf);
        //把翻转的后部分恢复
        ListNode originSecondHalf = reverseListNode(reversedSecondHalf);
        firstHalfEnd.next = originSecondHalf;
        return result;
    }

    public ListNode getFirstHalfEnd(ListNode head){
        //1 2 3 3 2 1
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public ListNode reverseListNode(ListNode head){
        //1->2->3->null
        ListNode prev = null;
        while (head != null){
            ListNode node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }
        return prev;
    }

    public boolean equalsNode(ListNode node1,ListNode node2){
        while (node1 != null && node2 != null){
            if(node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
