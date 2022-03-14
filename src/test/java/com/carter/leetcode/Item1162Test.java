package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1162Test {

    @Test
    void maxDistance() {
        int ans = new Item1162().maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void maxDistance1() {
        int ans = new Item1162().maxDistance(new int[][]{
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}