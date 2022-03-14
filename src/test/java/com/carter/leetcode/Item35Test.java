package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item35Test {
    @Test
    void searchInsert0() {
        int idx = new Item35().searchInsert(new int[]{1, 2, 3, 5}, 2);
        MatcherAssert.assertThat(idx, Matchers.is(1));
    }

    @Test
    void searchInsert1() {
        int idx = new Item35().searchInsert(new int[]{1, 3, 5}, 2);
        MatcherAssert.assertThat(idx, Matchers.is(1));
    }

    @Test
    void searchInsert2() {
        int idx = new Item35().searchInsert(new int[]{1, 3, 5, 6}, 5);
        MatcherAssert.assertThat(idx, Matchers.is(2));
    }

    @Test
    void searchInsert3() {
        int idx = new Item35().searchInsert(new int[]{1, 3, 5, 6}, 0);
        MatcherAssert.assertThat(idx, Matchers.is(0));
    }

    @Test
    void searchInsert4() {
        int idx = new Item35().searchInsert(new int[]{1, 3, 5, 6}, 7);
        MatcherAssert.assertThat(idx, Matchers.is(4));
    }

    @Test
    void searchInsert5() {
        int idx = new Item35().searchInsert(new int[]{1}, 7);
        MatcherAssert.assertThat(idx, Matchers.is(1));
    }

    @Test
    void t0() {
        int idx = new Item35().t(new int[]{1, 2, 3, 5}, 2);
        MatcherAssert.assertThat(idx, Matchers.is(1));
    }

    @Test
    void t1() {
        int idx = new Item35().t(new int[]{1, 3, 5}, 2);
        MatcherAssert.assertThat(idx, Matchers.is(-1));
    }

    @Test
    void t2() {
        int idx = new Item35().t(new int[]{1, 3, 5, 6}, 5);
        MatcherAssert.assertThat(idx, Matchers.is(2));
    }

    @Test
    void t3() {
        int idx = new Item35().t(new int[]{1, 3, 5, 6}, 0);
        MatcherAssert.assertThat(idx, Matchers.is(-1));
    }

    @Test
    void t4() {
        int idx = new Item35().t(new int[]{1, 3, 5, 6}, 7);
        MatcherAssert.assertThat(idx, Matchers.is(-1));
    }

    @Test
    void t5() {
        int idx = new Item35().t(new int[]{1}, 7);
        MatcherAssert.assertThat(idx, Matchers.is(-1));
    }
}