package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item18Test {

    @Test
    void fourSum() {
        List<List<Integer>> ans = new Item18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(-2, -1, 1, 2), Arrays.asList(-2, 0, 0, 2), Arrays.asList(-1, 0, 0, 1))));
    }

    @Test
    void fourSum4() {
        List<List<Integer>> ans = new Item18().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(-2, -1, 1, 2), Arrays.asList(-1, -1, 1, 1))));
    }

    @Test
    void fourSum1() {
        List<List<Integer>> ans = new Item18().fourSum(new int[]{2}, 8);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList()));
    }

    @Test
    void fourSum2() {
        List<List<Integer>> ans = new Item18().fourSum(new int[]{}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList()));
    }

    @Test
    void fourSum3() {
        List<List<Integer>> ans = new Item18().fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(2, 2, 2, 2))));
    }
}