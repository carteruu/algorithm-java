package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2073Test {

    @Test
    void timeRequiredToBuy() {
        int ans = new Item2073().timeRequiredToBuy(new int[]{2, 3, 2}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void timeRequiredToBuy1() {
        int ans = new Item2073().timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void timeRequiredToBuy2() {
        int ans = new Item2073().timeRequiredToBuy(new int[]{5}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}