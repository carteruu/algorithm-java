package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item69Test {

    @Test
    void mySqrt() {
        int sqrt = new Item69().mySqrt(8);
        MatcherAssert.assertThat(sqrt, Matchers.is(2));
    }

    @Test
    void mySqrt1() {
        int sqrt = new Item69().mySqrt(9);
        MatcherAssert.assertThat(sqrt, Matchers.is(3));
    }

    @Test
    void mySqrt2() {
        int sqrt = new Item69().mySqrt(0);
        MatcherAssert.assertThat(sqrt, Matchers.is(0));
    }

    @Test
    void mySqrt3() {
        int sqrt = new Item69().mySqrt(2147395599);
        MatcherAssert.assertThat(sqrt, Matchers.is(46339));
    }
}