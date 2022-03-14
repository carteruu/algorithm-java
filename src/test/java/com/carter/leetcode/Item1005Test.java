package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1005Test {
    @Test
    void largestSumAfterKNegations() {
        int ans = new Item1005().largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6);
        MatcherAssert.assertThat(ans, Matchers.is(22));
    }

    @Test
    void largestSumAfterKNegations4() {
        int ans = new Item1005().largestSumAfterKNegations(new int[]{4, 2, 3, 1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void largestSumAfterKNegations3() {
        int ans = new Item1005().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void largestSumAfterKNegations2() {
        int ans = new Item1005().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(13));
    }

    @Test
    void largestSumAfterKNegations1() {
        int ans = new Item1005().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }
}