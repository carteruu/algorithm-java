package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item100Test {

    @Test
    void isSameTree() {
        boolean sameTree = new Item100().isSameTree(null, null);
        MatcherAssert.assertThat(sameTree, Matchers.is(true));
    }

    @Test
    void isSameTree1() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        boolean sameTree = new Item100().isSameTree(p, q);
        MatcherAssert.assertThat(sameTree, Matchers.is(false));
    }
}