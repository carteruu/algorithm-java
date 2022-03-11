package com.carter.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Item1625 {
    public static class LRUCache {
        private final Map<Integer, Node> cache;
        private final Node dummyHead;
        private final Node dummyTail;
        private final int capacity;

        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException("容量不能小于1");
            }
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public int get(int key) {
            Node node = this.cache.get(key);
            if (node != null) {
                moveToHead(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = this.cache.get(key);
            if (node == null) {
                if (this.cache.size() >= this.capacity) {
                    this.cache.remove(dummyTail.pre.key);
                    this.removeNode(dummyTail.pre);
                }
                node = new Node(key, value);
                this.addToHead(node);
            } else {
                node.val = value;
                this.moveToHead(node);
            }
            this.cache.put(key, node);
        }

        private void moveToHead(Node node) {
            //存在
            if (node.pre != dummyHead) {
                //节点不在头,将节点移动到头
                removeNode(node);
                addToHead(node);
            }
        }

        private void removeNode(Node node) {
            //从原来的位置删除
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        private void addToHead(Node node) {
            //加入头
            node.next = dummyHead.next;
            node.next.pre = node;
            node.pre = dummyHead;
            dummyHead.next = node;
        }

        private static class Node {
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            private int key;
            private int val;
            private Node pre;
            private Node next;
        }
    }

    public static class LRUCache1 {
        private final LinkedHashMap<Integer, Integer> cache;
        private final int capacity;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {

                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return this.size() > LRUCache1.this.capacity;
                }
            };
        }

        public int get(int key) {
            if (!this.cache.containsKey(key)) {
                return -1;
            }
            return this.cache.get(key);
        }

        public void put(int key, int value) {
            this.cache.put(key, value);
        }
    }
}
