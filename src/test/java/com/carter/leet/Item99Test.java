package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item99Test {

    @Test
    void recoverTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Item99().recoverTree(root);
        MatcherAssert.assertThat(root.val, Matchers.is(2));
    }

    @Test
    void recoverTree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new Item99().recoverTree(root);
        MatcherAssert.assertThat(root.val, Matchers.is(3));
    }
}