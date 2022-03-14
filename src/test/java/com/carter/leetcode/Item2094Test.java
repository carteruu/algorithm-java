package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2094Test {

    @Test
    void findEvenNumbers() {
        int[] ans = new Item2094().findEvenNumbers(new int[]{2, 1, 3, 0});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320}));
    }

    @Test
    void findEvenNumbers2() {
        int[] ans = new Item2094().findEvenNumbers(new int[]{2, 2, 8, 8, 2});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{222, 228, 282, 288, 822, 828, 882}));
    }

    @Test
    void findEvenNumbers1() {
        int[] ans = new Item2094().findEvenNumbers(new int[]{0, 0, 0});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{}));
    }
}