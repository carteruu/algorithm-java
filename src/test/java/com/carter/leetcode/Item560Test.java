package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item560Test {

    @Test
    void subarraySum() {
        int count = new Item560().subarraySum(new int[]{1, 1, 1}, 2);
        MatcherAssert.assertThat(count, Matchers.is(2));
    }

    @Test
    void subarraySum1() {
        int count = new Item560().subarraySum(new int[]{1, 2, 1, 2, 1}, 3);
        MatcherAssert.assertThat(count, Matchers.is(4));
    }
}