package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Item113Test {

    @Test
    void hasPathSum() {
        List<List<Integer>> lists = new Item113().pathSum(new TreeNode(1), 1);
        MatcherAssert.assertThat(lists, Matchers.is(Arrays.asList(Arrays.asList(1))));
    }

    @Test
    void hasPathSum1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<Integer>> lists = new Item113().pathSum(root, 1);
        MatcherAssert.assertThat(lists, Matchers.is(Collections.emptyList()));
    }
}