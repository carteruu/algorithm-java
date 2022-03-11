package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item689Test {
    @Test
    void maxSumOfThreeSubarrays() {
        int[] ans = new Item689().maxSumOfThreeSubarrays(new int[]{4, 5, 10, 6, 11, 17, 4, 11, 1, 3}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{4, 5, 7}));
    }

    @Test
    void maxSumOfThreeSubarrays3() {
        int[] ans = new Item689().maxSumOfThreeSubarrays(new int[]{2, 1, 2, 6, 7, 5, 1, 2, 6, 7, 5, 1}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{2, 4, 8}));
    }

    @Test
    void maxSumOfThreeSubarrays2() {
        int[] ans = new Item689().maxSumOfThreeSubarrays(new int[]{2, 6, 7, 5, 1, 2, 6, 7, 5, 1}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0, 2, 6}));
    }

    @Test
    void maxSumOfThreeSubarrays1() {
        int[] ans = new Item689().maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0, 3, 5}));
    }
}