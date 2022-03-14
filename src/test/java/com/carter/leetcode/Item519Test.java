package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item519Test {
    @Test
    void solution() {
        Item519.Solution solution = new Item519.Solution(3, 1);
        int[] ans = solution.flip();
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1}));
        ans = solution.flip();
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1}));
        ans = solution.flip();
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1}));
        solution.reset();
        ans = solution.flip();
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1}));
    }
}