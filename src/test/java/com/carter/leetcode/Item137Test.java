package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item137Test {
    @Test
    void singleNumber() {
        int ans = new Item137().singleNumber(new int[]{2, 2, 3, 2});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void singleNumber3() {
        int ans = new Item137().singleNumber(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void singleNumber2() {
        int ans = new Item137().singleNumber(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 3, Integer.MIN_VALUE});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void singleNumber1() {
        int ans = new Item137().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
        MatcherAssert.assertThat(ans, Matchers.is(99));
    }
}
