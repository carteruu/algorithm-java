package com.carter.offer;

public class Item36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] ans = dfs(root);
        ans[0].left = ans[1];
        ans[1].right = ans[0];
        return ans[0];
    }

    private Node[] dfs(Node node) {
        if (node == null) {
            return null;
        }
        Node[] min = dfs(node.left);
        Node[] max = dfs(node.right);

        Node[] ans = new Node[2];
        if (min != null) {
            ans[0] = min[0];
            min[1].right = node;
            node.left = min[1];
        } else {
            ans[0] = node;
        }
        if (max != null) {
            ans[1] = max[1];
            node.right = max[0];
            max[0].left = node;
        } else {
            ans[1] = node;
        }
        return ans;
    }

    static class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void dfs(Node cur) {
            if (cur == null) {
                return;
            }
            dfs(cur.left);
            if (pre != null) {
                pre.right = cur;
            } else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
}


