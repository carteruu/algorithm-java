package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item198Test {

    @Test
    void rob() {
        int ans = new Item198$2().rob(new int[]{1, 2, 3, 1});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void rob3() {
        int ans = new Item198$2().rob(new int[]{2, 1, 1, 2});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void rob2() {
        int ans = new Item198$2().rob(new int[]{});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void rob1() {
        int ans = new Item198$2().rob(new int[]{2, 7, 9, 3, 1});
        MatcherAssert.assertThat(ans, Matchers.is(12));
    }
}