package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2023Test {

    @Test
    void numOfPairs() {
        int ans = new Item2023().numOfPairs(new String[]{"777", "7", "77", "77"}, "7777");
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}