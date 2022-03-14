package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item56Test {
    @Test
    void merge() {
        int[][] res = new Item56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        MatcherAssert.assertThat(res, Matchers.is(new int[][]{{1, 6}, {8, 10}, {15, 18}}));
    }

    @Test
    void merge2() {
        int[][] res = new Item56().merge(new int[][]{{1, 4}, {0, 0}});
        MatcherAssert.assertThat(res, Matchers.is(new int[][]{{0, 0}, {1, 4}}));
    }

    @Test
    void merge1() {
        int[][] res = new Item56().merge(new int[][]{{1, 4}, {4, 5}});
        MatcherAssert.assertThat(res, Matchers.is(new int[][]{{1, 5}}));
    }
}
