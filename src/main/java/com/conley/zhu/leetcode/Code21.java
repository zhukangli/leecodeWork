package com.conley.zhu.leetcode;

public class Code21 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //一开始居然没有想到可以建一个头结点
        ListNode headNode = new ListNode(-1);
        ListNode node = headNode;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                //2->2->4
                //1->3->4
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        System.out.println(new Code21().mergeTwoLists(node1,node4));
    }

}
