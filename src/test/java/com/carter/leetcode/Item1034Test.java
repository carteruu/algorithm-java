package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1034Test {
    @Test
    void colorBorder() {
        int[][] ans = new Item1034().colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 3);
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{3, 3, 3}, {3, 1, 3}, {3, 3, 3}}));
    }
}