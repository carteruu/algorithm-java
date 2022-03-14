package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item74Test {

    @Test
    void searchMatrix() {
        boolean ans = new Item74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void searchMatrix3() {
        boolean ans = new Item74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, -1);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void searchMatrix2() {
        boolean ans = new Item74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 5);
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void searchMatrix1() {
        boolean ans = new Item74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 61);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}