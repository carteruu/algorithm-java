package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item105Test {

    @Test
    void buildTree() {
        TreeNode rs = new Item105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        MatcherAssert.assertThat(rs.val, Matchers.is(3));
        MatcherAssert.assertThat(rs.left.val, Matchers.is(9));
    }
}