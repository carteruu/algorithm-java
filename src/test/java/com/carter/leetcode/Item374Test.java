package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item374Test {

    @Test
    void guessNumber() {
        int res = new Item374().guessNumber(8);
        MatcherAssert.assertThat(res, Matchers.is(4));
    }
}