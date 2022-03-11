package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item39Test {

    @Test
    void combinationSum() {
        List<List<Integer>> ans = new Item39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7))));
    }

    @Test
    void combinationSum3() {
        List<List<Integer>> ans = new Item39().combinationSum(new int[]{2, 3, 5}, 8);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5))));
    }

    @Test
    void combinationSum2() {
        List<List<Integer>> ans = new Item39().combinationSum(new int[]{2}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList()));
    }

    @Test
    void combinationSum1() {
        List<List<Integer>> ans = new Item39().combinationSum(new int[]{1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1))));
    }


    @Test
    void combinationSum31() {
        int ans = new Item39().combinationSum3(new int[]{2, 3, 6, 7}, 7);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}