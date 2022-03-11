package com.carter.off;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item04Test {

    @Test
    void findNumberIn2DArray() {
        boolean ans = new Item04().findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5);
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void findNumberIn2DArray1() {
        boolean ans = new Item04().findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}