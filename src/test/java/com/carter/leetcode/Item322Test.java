package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item322Test {

    @Test
    void coinChange() {
        int ans = new Item322().coinChange(new int[]{1, 2, 5}, 11);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void coinChange4() {
        int ans = new Item322().coinChange(new int[]{1, 2147483647}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void coinChange3() {
        int ans = new Item322().coinChange(new int[]{2}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void coinChange2() {
        int ans = new Item322().coinChange(new int[]{1}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}