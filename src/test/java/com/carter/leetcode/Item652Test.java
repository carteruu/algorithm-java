package com.carter.leetcode;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Item652Test {

    @Test
    void findDuplicateSubtrees() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        List<TreeNode> rs = new Item652().findDuplicateSubtrees(root);
        MatcherAssert.assertThat(rs.stream().map(node -> node.val).collect(Collectors.toList()), Matchers.is(Arrays.asList(root.right.left.val)));
    }
}