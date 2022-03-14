package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Item90Test {
    @Test
    void subsetsWithDup() {
        List<List<Integer>> ans = new Item90().subsetsWithDup(new int[]{1, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(1, 2), Arrays.asList(1, 2, 2), Arrays.asList(2), Arrays.asList(2, 2))));
    }

    @Test
    void subsetsWithDup1() {
        List<List<Integer>> ans = new Item90().subsetsWithDup(new int[]{0});
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(), Arrays.asList(0))));
    }
}
