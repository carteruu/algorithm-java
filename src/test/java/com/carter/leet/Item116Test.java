package com.carter.leet;

import com.carter.Node;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item116Test {

    @Test
    void connect() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node rs = new Item116().connect(root);
        MatcherAssert.assertThat(rs.next, Matchers.nullValue());
        MatcherAssert.assertThat(rs.left.next, Matchers.is(root.right));
    }
}