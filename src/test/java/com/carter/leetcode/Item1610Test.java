package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Item1610Test {
    @Test
    void visiblePoints() {
        int ans = new Item1610().visiblePoints(Arrays.asList(Arrays.asList(60, 61), Arrays.asList(58, 47), Arrays.asList(17, 26), Arrays.asList(87, 97), Arrays.asList(63, 63), Arrays.asList(26, 50), Arrays.asList(70, 21), Arrays.asList(3, 89), Arrays.asList(51, 24), Arrays.asList(55, 14), Arrays.asList(6, 51), Arrays.asList(64, 21), Arrays.asList(66, 33), Arrays.asList(54, 35), Arrays.asList(87, 38), Arrays.asList(30, 0), Arrays.asList(37, 92), Arrays.asList(92, 12), Arrays.asList(60, 73), Arrays.asList(75, 98), Arrays.asList(1, 11), Arrays.asList(88, 24), Arrays.asList(82, 92)), 44, Arrays.asList(15, 50));
        MatcherAssert.assertThat(ans, Matchers.is(11));
    }

    @Test
    void visiblePoints3() {
        int ans = new Item1610().visiblePoints(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 2), Arrays.asList(3, 3), Arrays.asList(4, 4), Arrays.asList(1, 2), Arrays.asList(2, 1)), 0, Arrays.asList(1, 1));
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void visiblePoints2() {
        int ans = new Item1610().visiblePoints(Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 1)), 13, Arrays.asList(1, 1));
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void visiblePoints1() {
        int ans = new Item1610().visiblePoints(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(2, 2), Arrays.asList(3, 3)), 90, Arrays.asList(1, 1));
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}