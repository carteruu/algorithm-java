package com.carter.contest;

import com.carter.leetcode.Item2172;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2172Test {
    @Test
    void maximumANDSum() {
        int ans = new Item2172().maximumANDSum(new int[]{14, 7, 9, 8, 2, 4, 11, 1, 9}, 8);
        MatcherAssert.assertThat(ans, Matchers.is(9));
    }

    @Test
    void maximumANDSum2() {
        int ans = new Item2172().maximumANDSum(new int[]{1, 3, 10, 4, 7, 1}, 9);
        MatcherAssert.assertThat(ans, Matchers.is(24));
    }

    @Test
    void maximumANDSum1() {
        int ans = new Item2172().maximumANDSum(new int[]{1, 3, 10, 4, 7, 1}, 9);
        MatcherAssert.assertThat(ans, Matchers.is(24));
    }
}