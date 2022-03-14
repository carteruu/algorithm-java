package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item912Test {

    @Test
    void sortArray() {
        int[] res = new Item912().sortArray(new int[]{5, 2, 3, 1});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{1, 2, 3, 5}));
    }

    @Test
    void sortArray1() {
        int[] res = new Item912().sortArray(new int[]{5, 1, 1, 2, 0, 0});
        MatcherAssert.assertThat(res, Matchers.is(new int[]{0, 0, 1, 1, 2, 5}));
    }
}