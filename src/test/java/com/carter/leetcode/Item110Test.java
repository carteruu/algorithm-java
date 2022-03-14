package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item110Test {

    @Test
    void isBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3));
        root.right = new TreeNode(2);
        boolean balanced = new Item110().isBalanced(root);
        MatcherAssert.assertThat(balanced, Matchers.is(false));
    }

    @Test
    void isBalanced2() {
        TreeNode root = new TreeNode(1);
        boolean balanced = new Item110().isBalanced(root);
        MatcherAssert.assertThat(balanced, Matchers.is(true));
    }

    @Test
    void isBalanced1() {
        TreeNode root = null;
        boolean balanced = new Item110().isBalanced(root);
        MatcherAssert.assertThat(balanced, Matchers.is(true));
    }
}