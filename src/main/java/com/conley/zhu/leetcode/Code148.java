package com.conley.zhu.leetcode;

/**
 * 这是第一次遇到归并排序的题，虽然下一次不一定能写出来，但是暂时了解了归并排序的原理，也是不错的
 */
public class Code148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *  思路就是归并排序
     *  分割,合并 不断根据步长重复，直到序列不可以再分
     *
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        int length = getLength(head);
        //哨兵
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        //开始归并
        for (int i = 1; i < length; i *= 2) {
            ListNode prev = sentry;
            ListNode curr = sentry.next;
            //下面这部分还有优点难理解的，下次做到的时候再看看
            while (curr != null){
                //分割为左右两部分
                ListNode left = curr;
                ListNode right = split(left,i);
                //往后推指针，跟步长i是有关的，不能直接right.next
                curr = split(right,i);
                //归并
                prev.next = merTwoLists(left,right);
                //把prev指针移动到下一个排序点
                while (prev.next != null){
                    prev = prev.next;
                }
            }
        }
        return sentry.next;
    }

    public int getLength(ListNode head){
        int i = 0;
        //重新写一个指针，不然会改变head的值
        ListNode curr = head;
        while (curr != null){
            i++;
            curr = curr.next;
        }
        return i;
    }

    /**
     *  分割算法
     *  2->3->5->4
     *  把序列按步长step分割为两部分
     *  返回右边部分的初始指针
     *
     */
    public ListNode split(ListNode head,int step){
        if(head == null)return null;
        for(int i = 1;head.next != null && i<step;i++){
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    /**
     *  合并链表 并保持有序
     *
     */
    public ListNode merTwoLists(ListNode n1,ListNode n2){
        //弄一个哨兵节点，要理解这个方法，很多地方都用的
        ListNode first = new ListNode(-1);
        ListNode curr = first;
        while (n1 != null && n2 != null){
            if(n1.val < n2.val){
                curr.next = n1;
                n1 = n1.next;
            }else{
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        curr.next = n1 != null ? n1 : n2;
        return first.next;
    }
}
