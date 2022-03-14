package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1074Test {

    @Test
    void numSubmatrixSumTarget() {
        int count = new Item1074().numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0);
        MatcherAssert.assertThat(count, Matchers.is(4));
    }

    @Test
    void numSubmatrixSumTarget1() {
        int count = new Item1074().numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0);
        MatcherAssert.assertThat(count, Matchers.is(5));
    }
}