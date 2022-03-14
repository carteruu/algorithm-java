package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import com.carter.TreeNode;

public class Item114Test {
    @Test
    void flatten() {
        TreeNode root = new TreeNode(2);
        new Item114().flatten(root);
        MatcherAssert.assertThat(root.val, Matchers.is(2));
    }

    @Test
    void flatten2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        new Item114().flatten(root);
        MatcherAssert.assertThat(root.val, Matchers.is(2));
        MatcherAssert.assertThat(root.right.val, Matchers.is(1));
        MatcherAssert.assertThat(root.right.right.val, Matchers.is(3));
    }

    @Test
    void flatten1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new Item114().flatten(root);
        MatcherAssert.assertThat(root.val, Matchers.is(2));
        MatcherAssert.assertThat(root.right.val, Matchers.is(1));
        MatcherAssert.assertThat(root.left, Matchers.nullValue());
        MatcherAssert.assertThat(root.right.right.val, Matchers.is(3));
    }
}
