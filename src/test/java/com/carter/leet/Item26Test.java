package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item26Test {

    @Test
    void removeDuplicates() {
        int[] nums = {1, 1, 2};
        int count = new Item26_1().removeDuplicates(nums);
        MatcherAssert.assertThat(count, Matchers.is(2));
        MatcherAssert.assertThat(nums[0], Matchers.is(1));
        MatcherAssert.assertThat(nums[1], Matchers.is(2));
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {1, 1};
        int count = new Item26_1().removeDuplicates(nums);
        MatcherAssert.assertThat(count, Matchers.is(1));
        MatcherAssert.assertThat(nums[0], Matchers.is(1));
    }

    @Test
    void removeDuplicates3() {
        int[] nums = {};
        int count = new Item26_1().removeDuplicates(nums);
        MatcherAssert.assertThat(count, Matchers.is(0));
    }

    @Test
    void removeDuplicates1() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = new Item26_1().removeDuplicates(nums);
        MatcherAssert.assertThat(count, Matchers.is(5));
        MatcherAssert.assertThat(nums[0], Matchers.is(0));
        MatcherAssert.assertThat(nums[1], Matchers.is(1));
        MatcherAssert.assertThat(nums[2], Matchers.is(2));
        MatcherAssert.assertThat(nums[3], Matchers.is(3));
        MatcherAssert.assertThat(nums[4], Matchers.is(4));
    }
}