package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item416Test {

    @Test
    void canPartition() {
        boolean ans = new Item416().canPartition(new int[]{1, 5, 11, 5});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void canPartition3() {
        boolean ans = new Item416().canPartition(new int[]{1, 2, 5});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void canPartition2() {
        boolean ans = new Item416().canPartition(new int[]{1, 2});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void canPartition1() {
        boolean ans = new Item416().canPartition(new int[]{1, 2, 3, 5});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}