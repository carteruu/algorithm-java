package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item124Test {

    @Test
    void maxPathSum() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int rs = new Item124().maxPathSum(root);
        MatcherAssert.assertThat(rs, Matchers.is(6));
    }

    @Test
    void maxPathSum3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        int rs = new Item124().maxPathSum(root);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void maxPathSum2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        int rs = new Item124().maxPathSum(root);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void maxPathSum1() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int rs = new Item124().maxPathSum(root);
        MatcherAssert.assertThat(rs, Matchers.is(42));
    }
}