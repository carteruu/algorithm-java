package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item877Test {

    @Test
    void stoneGame() {
        boolean rs = new Item877().stoneGame1(new int[]{5, 3, 4, 5});
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void stoneGame1() {
        boolean rs = new Item877().stoneGame1(new int[]{7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24});
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }
}