package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2029Test {

    @Test
    void stoneGameIX() {
        boolean ans = new Item2029().stoneGameIX(new int[]{2, 1});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void stoneGameIX2() {
        boolean ans = new Item2029().stoneGameIX(new int[]{2});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void stoneGameIX1() {
        boolean ans = new Item2029().stoneGameIX(new int[]{5, 1, 2, 4, 3});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}