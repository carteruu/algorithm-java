package com.carter.contest;

import com.carter.leetcode.Item2179;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2179Test {
    @Test
    void goodTriplets2() {
        long ans = new Item2179().goodTriplets(new int[]{2, 0, 1, 3}, new int[]{0, 1, 2, 3});
        MatcherAssert.assertThat(ans, Matchers.is(1L));
    }

    @Test
    void goodTriplets1() {
        long ans = new Item2179().goodTriplets(new int[]{4, 0, 1, 3, 2}, new int[]{4, 1, 0, 2, 3});
        MatcherAssert.assertThat(ans, Matchers.is(4L));
    }
}