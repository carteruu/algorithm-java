package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2162Test {

    @Test
    void minCostSetTime() {
        int ans = new Item2162().minCostSetTime(7,
                220,
                479,
                6000);
        MatcherAssert.assertThat(ans, Matchers.is(2576));
    }

    @Test
    void minCostSetTime4() {
        int ans = new Item2162().minCostSetTime(0,
                9,
                18,
                460);
        MatcherAssert.assertThat(ans, Matchers.is(81));
    }

    @Test
    void minCostSetTime3() {
        int ans = new Item2162().minCostSetTime(0,
                1,
                4,
                9);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void minCostSetTime2() {
        int ans = new Item2162().minCostSetTime(1,
                2,
                1,
                600);
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void minCostSetTime1() {
        int ans = new Item2162().minCostSetTime(0,
                1,
                2,
                76);
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }
}