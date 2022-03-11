package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item129Test {

    @Test
    void sumNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int rs = new Item129().sumNumbers(root);
        MatcherAssert.assertThat(rs, Matchers.is(25));
    }
}