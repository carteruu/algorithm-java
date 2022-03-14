package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2065Test {
    @Test
    void maximalPathQuality() {
        int ans = new Item2065().maximalPathQuality(new int[]{61, 11, 18, 43, 81},
                new int[][]{{0, 3, 45}, {0, 2, 16}, {0, 1, 36}, {3, 4, 38}, {2, 3, 29}},
                88);
        MatcherAssert.assertThat(ans, Matchers.is(79));
    }

    @Test
    void maximalPathQuality4() {
        int ans = new Item2065().maximalPathQuality(new int[]{0, 32, 10, 43},
                new int[][]{{0, 1, 10}, {1, 2, 15}, {0, 3, 10}},
                49);
        MatcherAssert.assertThat(ans, Matchers.is(75));
    }

    @Test
    void maximalPathQuality3() {
        int ans = new Item2065().maximalPathQuality(new int[]{0, 1, 2},
                new int[][]{{1, 2, 10}},
                10);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void maximalPathQuality1() {
        int ans = new Item2065().maximalPathQuality(new int[]{5, 10, 15, 20},
                new int[][]{{0, 1, 10}, {1, 2, 10}, {0, 3, 10}},
                30);
        MatcherAssert.assertThat(ans, Matchers.is(25));
    }

    @Test
    void maximalPathQuality2() {
        int ans = new Item2065().maximalPathQuality(new int[]{1, 2, 3, 4},
                new int[][]{{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}},
                50);
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }
}