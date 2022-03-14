package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item279Test {

    @Test
    void numSquares() {
        int rs = new Item279().numSquares(12);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void numSquares2() {
        int rs = new Item279().numSquares(6922);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void numSquares1() {
        int rs = new Item279().numSquares(13);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }
}