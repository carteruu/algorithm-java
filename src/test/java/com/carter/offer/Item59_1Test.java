package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item59_1Test {

    @Test
    void maxSlidingWindow() {
        int[] ans = new Item59_1().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{3, 3, 5, 5, 6, 7}));
    }

    @Test
    void maxSlidingWindow2() {
        int[] ans = new Item59_1().maxSlidingWindow(new int[]{}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{}));
    }

    @Test
    void maxSlidingWindow1() {
        int[] ans = new Item59_1().maxSlidingWindow(new int[]{1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1}));
    }
}