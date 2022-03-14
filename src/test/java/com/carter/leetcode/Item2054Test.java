package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2054Test {

    @Test
    void maxTwoEvents() {
        int ans = new Item2054().maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void maxTwoEvents2() {
        int ans = new Item2054().maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {1, 5, 5}});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void maxTwoEvents1() {
        int ans = new Item2054().maxTwoEvents(new int[][]{{1, 5, 3}, {1, 5, 1}, {6, 6, 5}});
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }
}