package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item114$1Test {

    @Test
    void preorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> rs = new Item114$1().preorderTraversal(root);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList(1, 2, 3)));
    }
}