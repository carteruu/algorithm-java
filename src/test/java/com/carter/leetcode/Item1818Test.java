package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1818Test {

    @Test
    void minAbsoluteSumDiff() {
        int rs = new Item1818().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5});
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void minAbsoluteSumDiff2() {
        int rs = new Item1818().minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4});
        MatcherAssert.assertThat(rs, Matchers.is(20));
    }

    @Test
    void minAbsoluteSumDiff1() {
        int rs = new Item1818().minAbsoluteSumDiff(new int[]{2, 4, 6, 8, 10}, new int[]{2, 4, 6, 8, 10});
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }
}