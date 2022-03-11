package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        List<Node> curList = root.children;
        while (curList != null && curList.size() > 0) {
            List<Node> nextList = new ArrayList<>();
            for (Node cur : curList) {
                if (cur.children != null) {
                    nextList.addAll(cur.children);
                }
            }
            max++;
            curList = nextList;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Item559().depth(null));

        System.out.println(new Item559().depth(new Node(1)));

        List<Node> c = new ArrayList<>();
        c.add(new Node(1));
        System.out.println(new Item559().depth(new Node(1, c)));
    }

    private int depth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int childMax = 0;
        for (Node n : root.children) {
            childMax = Math.max(childMax, depth(n));
        }
        return childMax + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
