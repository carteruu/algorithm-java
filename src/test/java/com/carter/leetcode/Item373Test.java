package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item373Test {

    @Test
    void kSmallestPairs() {
        List<List<Integer>> ans = new Item373().kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 3))));
    }
}