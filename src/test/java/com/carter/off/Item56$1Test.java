package com.carter.off;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item56$1Test {

    @Test
    void singleNumbers() {
        int[] ans = new Item56$1().singleNumbers(new int[]{4, 1, 4, 6});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 6}));
    }

    @Test
    void singleNumbers1() {
        int[] ans = new Item56$1().singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{10, 2}));
    }
}