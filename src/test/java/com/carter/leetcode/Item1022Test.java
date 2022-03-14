package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item1022Test {

    @Test
    void sumRootToLeaf() {
        int rs = new Item1022().sumRootToLeaf(new TreeNode(0));
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void sumRootToLeaf2() {
        int rs = new Item1022().sumRootToLeaf(new TreeNode(1));
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void sumRootToLeaf1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        int rs = new Item1022().sumRootToLeaf(root);
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }
}