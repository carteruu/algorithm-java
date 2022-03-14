package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2025Test {
    @Test
    void waysToPartition() {
        int ans = new Item2025().waysToPartition(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, -99, 0}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(60));
    }

    @Test
    void waysToPartition4() {
        int ans = new Item2025().waysToPartition(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30827, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(33));
    }

    @Test
    void waysToPartition3() {
        int ans = new Item2025().waysToPartition(new int[]{2, -1, 2}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void waysToPartition2() {
        int ans = new Item2025().waysToPartition(new int[]{0, 0, 0}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void waysToPartition1() {
        int ans = new Item2025().waysToPartition(new int[]{22, 4, -25, -20, -15, 15, -16, 7, 19, -10, 0, -13, -14}, -33);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}