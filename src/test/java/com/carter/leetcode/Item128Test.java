package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item128Test {

    @Test
    void longestConsecutive() {
        int ans = new Item128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void longestConsecutive2() {
        int ans = new Item128().longestConsecutive(new int[]{100, 4, 200, 1, 1, 3, 2});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void longestConsecutive1() {
        int ans = new Item128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        MatcherAssert.assertThat(ans, Matchers.is(9));
    }
}