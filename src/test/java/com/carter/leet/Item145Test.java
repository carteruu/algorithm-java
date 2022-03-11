package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item145Test {

    @Test
    void postorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> rs = new Item145().postorderTraversal(root);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList(3, 2, 1)));
    }
}