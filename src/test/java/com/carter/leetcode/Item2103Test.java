package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2103Test {
    @Test
    void test() {
        int ans = new Item2103().countPoints("B0B6G0R6R0R6G9");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void test2() {
        int ans = new Item2103().countPoints("B0R0G0R9R0B0G0");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void test1() {
        int ans = new Item2103().countPoints("G4");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}