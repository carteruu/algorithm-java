package com.carter.leet;

import com.carter.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item116 {
    public Node connect(Node root) {
        Node first = root;
        while (first.left != null) {
            Node start = first;
            while (start != null) {
                start.left.next = first.right;
                if (start.right != null && start.next != null) {
                    start.right.next = start.next.left;
                }
                start = start.next;
            }
            first = first.left;
        }
        return root;
    }

    public Node connect2(Node root) {
        connect(root, null);
        return root;
    }

    private void connect(Node left, Node right) {
        if (left != null) {
            left.next = right;
            connect(left.left, left.right);
        }
        if (right != null) {
            connect(right.left, right.right);
        }
        if (left != null && right != null) {
            connect(left.right, right.left);
        }
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }
}
