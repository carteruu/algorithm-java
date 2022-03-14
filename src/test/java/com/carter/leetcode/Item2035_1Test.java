package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2035_1Test {

    @Test
    void minimumDifference() {
        int ans = new Item2035_1().minimumDifference(new int[]{-7793, 88979, -50367, -90480, -74782, -99833, -89506, -48590, 87649, -13079});
        MatcherAssert.assertThat(ans, Matchers.is(362));
    }

    @Test
    void minimumDifference3() {
        int ans = new Item2035_1().minimumDifference(new int[]{2, -1, 0, 4, -2, -9});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void minimumDifference2() {
        int ans = new Item2035_1().minimumDifference(new int[]{3, 9, 7, 3});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void minimumDifference1() {
        int ans = new Item2035_1().minimumDifference(new int[]{-36, 36});
        MatcherAssert.assertThat(ans, Matchers.is(72));
    }
}