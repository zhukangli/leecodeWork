package com.conley.zhu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code146 {
    static class Node{
        private int key;
        private int val;
        private Node prev,next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList{
        private Node head,tail;
        private int size;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() { return size; }
    }


    public class LRUCache {
        private DoubleList cache;
        private Map<Integer,Node> map = new HashMap<>();
        private int cap;
        public LRUCache(int capacity) {
            cache = new DoubleList();
            cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            // 利用 put 方法把该数据提前
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            // 先把新节点 x 做出来
            Node x = new Node(key, val);

            if (map.containsKey(key)) {
                // 删除旧的节点，新的插到头部
                cache.remove(map.get(key));
                cache.addFirst(x);
                // 更新 map 中对应的数据
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    // 删除链表最后一个数据
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                // 直接添加到头部
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }
}
