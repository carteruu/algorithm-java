package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item11Test {

    @Test
    void maxArea() {
        int res = new Item11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        MatcherAssert.assertThat(res, Matchers.is(49));
    }

    @Test
    void maxArea4() {
        int res = new Item11().maxArea(new int[]{2, 1});
        MatcherAssert.assertThat(res, Matchers.is(1));
    }

    @Test
    void maxArea1() {
        int res = new Item11().maxArea(new int[]{1, 1});
        MatcherAssert.assertThat(res, Matchers.is(1));
    }

    @Test
    void maxArea2() {
        int res = new Item11().maxArea(new int[]{4, 3, 2, 1, 4});
        MatcherAssert.assertThat(res, Matchers.is(16));
    }

    @Test
    void maxArea3() {
        int res = new Item11().maxArea(new int[]{1, 2, 1});
        MatcherAssert.assertThat(res, Matchers.is(2));
    }
}