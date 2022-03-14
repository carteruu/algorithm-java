package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1446Test {

    @Test
    void maxPower() {
        int ans = new Item1446().maxPower("aaaa");
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void maxPower3() {
        int ans = new Item1446().maxPower("leetcode");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void maxPower2() {
        int ans = new Item1446().maxPower("abbcccddddeeeeedcba");
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void maxPower1() {
        int ans = new Item1446().maxPower("a");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}