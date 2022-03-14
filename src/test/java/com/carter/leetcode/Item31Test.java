package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item31Test {
    @Test
    void nextPermutation() {
        int[] nums = {1, 2, 3};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{1, 3, 2}));
    }

    @Test
    void nextPermutation6() {
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{4, 2, 0, 3, 0, 2, 2}));
    }

    @Test
    void nextPermutation5() {
        int[] nums = {3, 1, 2};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{3, 2, 1}));
    }

    @Test
    void nextPermutation4() {
        int[] nums = {1, 3, 2};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{2, 1, 3}));
    }

    @Test
    void nextPermutation3() {
        int[] nums = {1};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{1}));
    }

    @Test
    void nextPermutation2() {
        int[] nums = {3, 2, 1};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{1, 2, 3}));
    }

    @Test
    void nextPermutation1() {
        int[] nums = {1, 1, 5};
        new Item31().nextPermutation(nums);
        MatcherAssert.assertThat(nums, Matchers.is(new int[]{1, 5, 1}));
    }
}
