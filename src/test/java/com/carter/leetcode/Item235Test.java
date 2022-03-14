package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item235Test {

    @Test
    void lowestCommonAncestor() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode rs = new Item235().lowestCommonAncestor(root, root.left, root.left.right);
        MatcherAssert.assertThat(rs.val, Matchers.is(1));
    }
}