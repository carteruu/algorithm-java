package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item437Test {

    @Test
    void pathSum() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        int rs = new Item437().pathSum(root, 8);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void pathSum3() {
        int rs = new Item437().pathSum(new TreeNode(1), 0);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void pathSum2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        int rs = new Item437().pathSum(root, 2);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void pathSum1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int rs = new Item437().pathSum(root, 2);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }
}