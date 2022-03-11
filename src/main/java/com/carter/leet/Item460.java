package com.carter.leet;

import java.util.*;

public class Item460 {
    public static class LFUCache {
        private final Map<Integer, Node> cache;
        private final Map<Integer, Node[]> cnt2Head;
        private final int capacity;
        private int minCnt;

        public LFUCache(int capacity) {
            cache = new HashMap<>();
            cnt2Head = new HashMap<>();
            this.capacity = capacity;
            minCnt = 0;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveAndIncr(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = this.cache.get(key);
            if (node == null) {
                if (cache.size() == capacity) {
                    //删除最后一个节点
                    Node remove = cnt2Head.get(minCnt)[1].prev;
                    removeNode(remove);
                    cache.remove(remove.key);
                }

                node = new Node(key, value);
                cache.put(key, node);
                incrAndAddHead(node);
                minCnt = 1;
            } else {
                node.val = value;
                moveAndIncr(node);
            }
        }

        private void moveAndIncr(Node node) {
            removeNode(node);
            incrAndAddHead(node);
        }

        private void incrAndAddHead(Node node) {
            //访问次数+1
            node.cnt++;
            //加入新链表
            Node[] dummy = cnt2Head.get(node.cnt);
            if (dummy == null) {
                //该次数还没有链表，新建
                Node head = new Node();
                Node tail = new Node();
                //头指向尾的指针
                head.next = tail;
                tail.prev = head;
                dummy = new Node[]{head, tail};
                cnt2Head.put(node.cnt, dummy);
            }
            //新节点插入头部
            Node head = dummy[0];
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }

        private void removeNode(Node node) {
            //从原来的链表删除
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            //原链表为空，且为最小次数时，删除原链表，并将最小次数+1
            Node[] dummy = cnt2Head.get(node.cnt);
            if (dummy[0].next == dummy[1] && node.cnt == minCnt) {
                cnt2Head.remove(node.cnt);
                minCnt++;
            }
        }

        private static class Node {
            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            int key;
            int val;
            int cnt = 0;
            Node prev;
            Node next;
        }
    }
}