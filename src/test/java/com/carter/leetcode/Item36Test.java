package com.carter.leetcode;

import com.carter.Node;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item36Test {

    @Test
    void treeToDoublyList() {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        Node node = new Item36().treeToDoublyList(root);
        MatcherAssert.assertThat(node.val, Matchers.is(3));
    }

    @Test
    void treeToDoublyList1() {
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node node = new Item36().treeToDoublyList(root);
        MatcherAssert.assertThat(node.val, Matchers.is(1));
    }
}