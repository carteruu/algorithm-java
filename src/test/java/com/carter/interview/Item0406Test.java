package com.carter.interview;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item0406Test {

    @Test
    void inorderSuccessor() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode rs = new Item0406().inorderSuccessor(root, root.left);
        MatcherAssert.assertThat(rs.val, Matchers.is(root.val));
    }

    @Test
    void inorderSuccessor1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(0);
        TreeNode rs = new Item0406().inorderSuccessor(root, root.left.left);
        MatcherAssert.assertThat(rs.val, Matchers.is(root.left.val));
    }
}