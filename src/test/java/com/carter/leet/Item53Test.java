package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item53Test {

    @Test
    void maxSubArray() {
        int max = new Item53$2().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        MatcherAssert.assertThat(max, Matchers.is(6));
    }

    @Test
    void maxSubArray1() {
        int max = new Item53$2().maxSubArray(new int[]{1});
        MatcherAssert.assertThat(max, Matchers.is(1));
    }

    @Test
    void maxSubArray2() {
        int max = new Item53$2().maxSubArray(new int[]{-1});
        MatcherAssert.assertThat(max, Matchers.is(-1));
    }
}