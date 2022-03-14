package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2106Test {
    @Test
    void test() {
        int ans = new Item2106().maxTotalFruits(new int[][]{{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}}, 21, 30);
        MatcherAssert.assertThat(ans, Matchers.is(71));
    }

    @Test
    void test3() {
        int ans = new Item2106().maxTotalFruits(new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4);
        MatcherAssert.assertThat(ans, Matchers.is(9));
    }

    @Test
    void test2() {
        int ans = new Item2106().maxTotalFruits(new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}}, 5, 4);
        MatcherAssert.assertThat(ans, Matchers.is(14));
    }

    @Test
    void test1() {
        int ans = new Item2106().maxTotalFruits(new int[][]{{0, 3}, {6, 4}, {8, 5}}, 3, 2);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}