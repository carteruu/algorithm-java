package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item1001Test {
    @Test
    void gridIllumination() {
        int[] ans = new Item1001().gridIllumination(6,
                new int[][]{{1, 1}},
                new int[][]{{2, 0}, {1, 0}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 0}));
    }

    @Test
    void gridIllumination2() {
        int[] ans = new Item1001().gridIllumination(5,
                new int[][]{{0, 0}, {4, 4}},
                new int[][]{{1, 1}, {1, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1}));
    }

    @Test
    void gridIllumination1() {
        int[] ans = new Item1001().gridIllumination(5,
                new int[][]{{0, 0}, {0, 4}},
                new int[][]{{0, 4}, {0, 1}, {1, 4}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 1, 0}));
    }
}
