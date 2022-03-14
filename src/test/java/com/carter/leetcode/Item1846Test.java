package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1846Test {

    @Test
    void maximumElementAfterDecrementingAndRearranging() {
        int rs = new Item1846().maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1});
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void maximumElementAfterDecrementingAndRearranging1() {
        int rs = new Item1846().maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000});
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }
}