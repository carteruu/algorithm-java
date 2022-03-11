package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item851Test {
    @Test
    void loudAndRich() {
        int[] ans = new Item851().loudAndRich(new int[][]{{0, 1}, {0, 2}}, new int[]{1, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0, 1, 0}));
    }@Test
    void loudAndRich2() {
        int[] ans = new Item851().loudAndRich(new int[][]{{0, 2}, {1, 2}}, new int[]{0, 1, 2});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0, 1, 0}));
    }

    @Test
    void loudAndRich1() {
        int[] ans = new Item851().loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{5, 5, 2, 5, 4, 5, 6, 7}));
    }
}