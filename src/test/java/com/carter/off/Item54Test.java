package com.carter.off;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item54Test {

    @Test
    void kthLargest() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        root.left = left;
        root.right = new TreeNode(6);

        TreeNode leftLeft = new TreeNode(2);
        left.left = leftLeft;
        left.right = new TreeNode(4);

        leftLeft.left = new TreeNode(1);
        int rs = new Item54().kthLargest(root, 3);
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }
}