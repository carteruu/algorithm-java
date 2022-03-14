package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item268Test {

    @Test
    void missingNumber() {
        int ans = new Item268().missingNumber(new int[]{0, 2, 3});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void missingNumber1() {
        int ans = new Item268().missingNumber(new int[]{0, 2, 1});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}