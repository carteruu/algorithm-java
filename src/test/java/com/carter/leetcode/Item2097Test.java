package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2097Test {

    @Test
    void validArrangement() {
        int[][] ans = new Item2097().validArrangement(new int[][]{{17, 18}, {18, 10}, {10, 18}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{17, 18}, {18, 10}, {10, 18}}));
    }

    @Test
    void validArrangement3() {
        int[][] ans = new Item2097().validArrangement(new int[][]{{8, 5}, {8, 7}, {0, 8}, {0, 5}, {7, 0}, {5, 0}, {0, 7}, {8, 0}, {7, 8}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{}));
    }

    @Test
    void validArrangement2() {
        int[][] ans = new Item2097().validArrangement(new int[][]{{1, 3}, {3, 2}, {2, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{1, 3}, {3, 2}, {2, 1}}));
    }

    @Test
    void validArrangement1() {
        int[][] ans = new Item2097().validArrangement(new int[][]{{5, 1}, {4, 5}, {11, 9}, {9, 4}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{11, 9}, {9, 4}, {4, 5}, {5, 1}}));
    }
}