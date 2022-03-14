package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class item2155Test {

    @Test
    void test1() {
        List<Integer> ans = new item2155().maxScoreIndices(new int[]{0, 0, 1, 0});
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(2, 4)));
    }
}