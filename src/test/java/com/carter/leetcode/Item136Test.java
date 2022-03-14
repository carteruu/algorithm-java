package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item136Test {

    @Test
    void singleNumber() {
        int ans = new Item136().singleNumber(new int[]{1, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}