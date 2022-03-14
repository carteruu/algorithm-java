package com.carter.offer;

import java.util.ArrayList;
import java.util.List;

public class Item62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        //从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public int lastRemaining3(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    private static class Node {
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node pre) {
            this.val = val;
            this.pre = pre;
        }

        private int val;
        private Node next;
        private Node pre;
    }

    public int lastRemaining1(int n, int m) {
        Node head = new Node(0);
        Node tail = head;
        for (int i = 0; i < n; i++) {
            tail.next = new Node(i, tail);
            tail = tail.next;
        }
        tail.next = head.next;
        head.next.pre = tail;
        Node cur = head;
        for (int i = 0; i < n - 1; i++) {
            int m1 = m % (n - i);
            for (int j = 0; j < m1; j++) {
                cur = cur.next;
            }
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
        return cur.next.val;
    }
}
