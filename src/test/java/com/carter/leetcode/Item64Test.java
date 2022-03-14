package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item64Test {

    @Test
    void minPathSum() {
        int ans = new Item64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }

    @Test
    void minPathSum3() {
        int ans = new Item64().minPathSum(new int[][]{{1, 2}, {5, 6}, {1, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void minPathSum2() {
        int ans = new Item64().minPathSum(new int[][]{{1, 2}, {1, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void minPathSum1() {
        int ans = new Item64().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
        MatcherAssert.assertThat(ans, Matchers.is(12));
    }
}