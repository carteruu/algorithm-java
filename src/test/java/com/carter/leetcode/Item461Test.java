package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item461Test {

    @Test
    void hammingDistance() {
        int count = new Item461().hammingDistance(1, 4);
        MatcherAssert.assertThat(count, Matchers.is(2));
    }
}