package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item458Test {

    @Test
    void poorPigs() {
        int ans = new Item458().poorPigs(1000, 15, 60);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}