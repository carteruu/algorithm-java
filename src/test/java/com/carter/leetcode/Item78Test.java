package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item78Test {

    @Test
    void subsets() {
        List<List<Integer>> ans = new Item78().subsets(new int[]{1, 2, 3});
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(1)));
    }
}