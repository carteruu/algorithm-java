package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1518Test {

    @Test
    void numWaterBottles() {
        int ans = new Item1518().numWaterBottles(9, 3);
        MatcherAssert.assertThat(ans, Matchers.is(13));
    }

    @Test
    void numWaterBottles2() {
        int ans = new Item1518().numWaterBottles(9, 2);
        MatcherAssert.assertThat(ans, Matchers.is(17));
    }

    @Test
    void numWaterBottles1() {
        int ans = new Item1518().numWaterBottles(999, 1000);
        MatcherAssert.assertThat(ans, Matchers.is(999));
    }
}