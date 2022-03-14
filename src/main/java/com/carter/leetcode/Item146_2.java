package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item146_2 {
    public static class Node {
        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        int key;
        int val;
        Node prev;
        Node next;
    }

    public static class LRUCache {
        private final int capacity;
        private final Node head;
        private final Node tail;
        private final Map<Integer, Node> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>((int) (capacity / 0.75) + 1);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = this.cache.get(key);
            if (node == null) {
                return -1;
            }
            this.moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = this.cache.get(key);
            if (node != null) {
                node.val = value;
                this.moveToHead(node);
            } else {
                node = new Node(key, value);
                this.cache.put(key, node);
                this.addToHead(node);

                if (this.cache.size() > this.capacity) {
                    Node remove = tail.prev;
                    this.cache.remove(remove.key);
                    this.removeNode(remove);
                }
            }
        }

        private void moveToHead(Node node) {
            this.removeNode(node);
            this.addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;

            node.prev.next = node;
            node.next.prev = node;
        }
    }
}
