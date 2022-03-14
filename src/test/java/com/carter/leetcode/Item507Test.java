package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item507Test {

    @Test
    void checkPerfectNumber() {
        boolean ans = new Item507().checkPerfectNumber(4);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}