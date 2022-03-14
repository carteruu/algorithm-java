package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class Item66Test {

    @Test
    void strangePrinter() {
        int[] nums = new Item66().plusOne(new int[]{1, 2, 3});
        MatcherAssert.assertThat(nums, is(new int[]{1, 2, 4}));
    }
}