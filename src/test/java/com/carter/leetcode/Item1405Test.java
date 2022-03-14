package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1405Test {

    @Test
    void longestDiverseString() {
        String ans = new Item1405().longestDiverseString(1,
                1,
                7);
        MatcherAssert.assertThat(ans, Matchers.is("ccaccbcc"));
    }
}