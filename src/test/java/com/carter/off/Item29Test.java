package com.carter.off;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item29Test {
    @Test
    void spiralOrder() {
        int[] res = new Item29().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}));
    }

    @Test
    void spiralOrder3() {
        int[] res = new Item29().spiralOrder(new int[][]{{}, {}, {}});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{}));
    }

    @Test
    void spiralOrder2() {
        int[] res = new Item29().spiralOrder(new int[][]{});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{}));
    }

    @Test
    void spiralOrder1() {
        int[] res = new Item29().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}));
    }
}
