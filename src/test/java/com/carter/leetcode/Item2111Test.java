package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2111Test {
    @Test
    void kIncreasing() {
        int ans = new Item2111().kIncreasing(new int[]{12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3}, 11);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void kIncreasing3() {
        int ans = new Item2111().kIncreasing(new int[]{5, 4, 3, 2, 1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void kIncreasing1() {
        int ans = new Item2111().kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void kIncreasing2() {
        int ans = new Item2111().kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}