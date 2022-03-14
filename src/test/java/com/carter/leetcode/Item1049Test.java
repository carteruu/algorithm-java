package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1049Test {

    @Test
    void lastStoneWeightII() {
        int rs = new Item1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void lastStoneWeightII1() {
        int rs = new Item1049().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }
}