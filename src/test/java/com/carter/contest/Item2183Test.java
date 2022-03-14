package com.carter.contest;

import com.carter.leetcode.Item2183;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2183Test {
    @Test
    void coutPairs() {
        long ans = new Item2183().coutPairs(new int[]{8, 10, 2, 5, 9, 6, 3, 8, 2}, 6);
        MatcherAssert.assertThat(ans, Matchers.is(18L));
    }

    @Test
    void coutPairs1() {
        long ans = new Item2183().coutPairs(new int[]{1, 2, 3, 4, 5}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(7L));
    }
}