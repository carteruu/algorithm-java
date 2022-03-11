package com.carter.leet;

import com.carter.leet.Item2022;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2022Test {

    @Test
    void construct2DArray() {
        int[][] ans = new Item2022().construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{1, 2}, {3, 4}}));
    }

    @Test
    void construct2DArray1() {
        int[][] ans = new Item2022().construct2DArray(new int[]{1, 2, 3}, 1, 4);
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{}));
    }

    @Test
    void construct2DArray2() {
        int[][] ans = new Item2022().construct2DArray(new int[]{1, 2, 3, 4}, 1, 4);
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{{1, 2, 3, 4}}));
    }

    @Test
    void construct2DArray3() {
        int[][] ans = new Item2022().construct2DArray(new int[]{1, 2}, 1, 1);
        MatcherAssert.assertThat(ans, Matchers.is(new int[][]{}));
    }
}