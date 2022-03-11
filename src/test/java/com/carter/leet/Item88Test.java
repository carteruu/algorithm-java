package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item88Test {
    @Test
    void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        new Item88().merge(nums1, 3, new int[]{2, 5, 6}, 3);
        MatcherAssert.assertThat(nums1, Matchers.is(new int[]{1, 2, 2, 3, 5, 6}));
    }

    @Test
    void merge3() {
        int[] nums1 = {1};
        new Item88().merge(nums1, 1, new int[]{}, 0);
        MatcherAssert.assertThat(nums1, Matchers.is(new int[]{1}));
    }

    @Test
    void merge2() {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        new Item88().merge(nums1, 1, new int[]{1, 2, 3, 5, 6}, 5);
        MatcherAssert.assertThat(nums1, Matchers.is(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void merge1() {
        int[] nums1 = {0};
        new Item88().merge(nums1, 0, new int[]{1}, 1);
        MatcherAssert.assertThat(nums1, Matchers.is(new int[]{1}));
    }
}