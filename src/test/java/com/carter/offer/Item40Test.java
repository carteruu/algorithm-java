package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item40Test {

    @Test
    void getLeastNumbers() {
        int[] ans = new Item40().getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0}));
    }

    @Test
    void getLeastNumbers1() {
        int[] ans = new Item40().getLeastNumbers(new int[]{}, 0);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{}));
    }
}