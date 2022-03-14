package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2091Test {
    @Test
    void test1() {
        int ans = new Item2091().minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void test() {
        int ans = new Item2091().minimumDeletions(new int[]{-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74});
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }
}