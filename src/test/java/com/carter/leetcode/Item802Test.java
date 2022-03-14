package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item802Test {

    @Test
    void eventualSafeNodes() {
        List<Integer> ans = new Item802().eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(2, 4, 5, 6)));
    }
}