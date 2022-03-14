package com.carter.leetcode;

import com.carter.Node;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item117Test {

    @Test
    void connect() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        Node rs = new Item117().connect(root);
        MatcherAssert.assertThat(rs.next, Matchers.nullValue());
        MatcherAssert.assertThat(rs.left.next.val, Matchers.is(root.right.val));
        MatcherAssert.assertThat(rs.left.left.next.val, Matchers.is(rs.left.right.val));
        MatcherAssert.assertThat(rs.left.right.next.val, Matchers.is(rs.right.right.val));
    }

    @Test
    void connect1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        Node rs = new Item117().connect(root);
    }
}