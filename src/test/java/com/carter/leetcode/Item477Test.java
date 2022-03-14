package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item477Test {

    @Test
    void totalHammingDistance1() {
        int count = new Item477().totalHammingDistance(new int[]{1, 2});
        MatcherAssert.assertThat(count, Matchers.is(2));
    }

    @Test
    void totalHammingDistance2() {
        int count = new Item477().totalHammingDistance(new int[]{4, 14, 2});
        MatcherAssert.assertThat(count, Matchers.is(6));
    }

    @Test
    void hammingDistance() {
        int count = new Item477().hammingDistance(1, 2);
        MatcherAssert.assertThat(count, Matchers.is(2));
    }
}