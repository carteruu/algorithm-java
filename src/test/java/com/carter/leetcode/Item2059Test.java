package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2059Test {

    @Test
    void minimumOperations() {
        int ans = new Item2059().minimumOperations(new int[]{-17}, 96, 79);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void minimumOperations5() {
        int ans = new Item2059().minimumOperations(new int[]{3, 5, 7}, 0, -4);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void minimumOperations4() {
        int ans = new Item2059().minimumOperations(new int[]{2, 4, 12}, 2, 12);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void minimumOperations3() {
        int ans = new Item2059().minimumOperations(new int[]{1, 3}, 6, 4);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void minimumOperations1() {
        int ans = new Item2059().minimumOperations(new int[]{2, 8, 16}, 0, 1);
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void minimumOperations2() {
        int ans = new Item2059().minimumOperations(new int[]{1}, 0, 3);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}