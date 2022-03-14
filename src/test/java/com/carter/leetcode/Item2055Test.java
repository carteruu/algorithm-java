package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2055Test {
    @Test
    void platesBetweenCandles() {
        int[] ans = new Item2055().platesBetweenCandles("*|*",
                new int[][]{{2, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0}));
    }

    @Test
    void platesBetweenCandles3() {
        int[] ans = new Item2055().platesBetweenCandles("***",
                new int[][]{{2, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0}));
    }

    @Test
    void platesBetweenCandles2() {
        int[] ans = new Item2055().platesBetweenCandles("**|**|***|",
                new int[][]{{2, 5}, {5, 9}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{2, 3}));
    }

    @Test
    void platesBetweenCandles1() {
        int[] ans = new Item2055().platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{9, 0, 0, 0, 0}));
    }
}