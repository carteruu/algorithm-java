package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item456Test {

    @Test
    void find132pattern() {
        boolean pattern = new Item456().find132pattern(new int[]{1, 2, 3, 4});
        MatcherAssert.assertThat(pattern, Matchers.is(false));
    }

    @Test
    void find132pattern3() {
        boolean pattern = new Item456().find132pattern(new int[]{1, 0, 1, -4, -3});
        MatcherAssert.assertThat(pattern, Matchers.is(false));
    }

    @Test
    void find132pattern2() {
        boolean pattern = new Item456().find132pattern(new int[]{3, 1, 4, 2});
        MatcherAssert.assertThat(pattern, Matchers.is(true));
    }

    @Test
    void find132pattern1() {
        boolean pattern = new Item456().find132pattern(new int[]{-1, 3, 2, 0});
        MatcherAssert.assertThat(pattern, Matchers.is(true));
    }
}