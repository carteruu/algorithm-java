package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item372Test {

    @Test
    void superPow() {
        int ans = new Item372().superPow(2, new int[]{3});
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void superPow2() {
        int ans = new Item372().superPow(2147483647, new int[]{2, 0, 0});
        MatcherAssert.assertThat(ans, Matchers.is(1198));
    }

    @Test
    void superPow1() {
        int ans = new Item372().superPow(1, new int[]{4, 3, 3, 8, 5, 2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}