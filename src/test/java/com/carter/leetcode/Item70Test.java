package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item70Test {

    @Test
    void climbStairs() {
        int step = new Item70().climbStairs(1);
        MatcherAssert.assertThat(step, Matchers.is(1));
    }

    @Test
    void climbStairs3() {
        int step = new Item70().climbStairs(4);
        MatcherAssert.assertThat(step, Matchers.is(5));
    }

    @Test
    void climbStairs2() {
        int step = new Item70().climbStairs(3);
        MatcherAssert.assertThat(step, Matchers.is(3));
    }

    @Test
    void climbStairs1() {
        int step = new Item70().climbStairs(2);
        MatcherAssert.assertThat(step, Matchers.is(2));
    }
}