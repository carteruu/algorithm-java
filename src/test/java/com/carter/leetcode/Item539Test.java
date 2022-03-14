package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Item539Test {

    @Test
    void findMinDifference() {
        int ans = new Item539().findMinDifference(Arrays.asList("23:59", "11:11", "00:00"));
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}