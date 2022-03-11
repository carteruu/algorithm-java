package com.carter.leet;

import com.carter.TreeNode;
import com.carter.leet.Item2096;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2096Test {

    @Test
    void getDirections() {
        TreeNode l = new TreeNode(1, new TreeNode(3), null);
        TreeNode right = new TreeNode(2, new TreeNode(6, null, null), new TreeNode(4, null, null));
        String ans = new Item2096().getDirections(new TreeNode(5, l, right), 3, 6);
        MatcherAssert.assertThat(ans, Matchers.is("UURL"));
    }
}