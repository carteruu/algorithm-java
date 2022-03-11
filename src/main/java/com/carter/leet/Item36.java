package com.carter.leet;

import com.carter.Node;

public class Item36 {
    private Node head = null;
    private Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (head == null) {
            head = node;
        } else {
            tail.right = node;
            node.left = tail;
        }
        tail = node;
        inorder(node.right);
    }
}
