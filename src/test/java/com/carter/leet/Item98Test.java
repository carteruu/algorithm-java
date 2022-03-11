package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item98Test {

    @Test
    void isValidBST() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        boolean rs = new Item98().isValidBST(root);
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }

    @Test
    void isValidBST2() {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        boolean rs = new Item98().isValidBST(root);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void isValidBST1() {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        boolean rs = new Item98().isValidBST(root);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }
}