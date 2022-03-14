package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item765Test {

    @Test
    void minSwapsCouples() {
        int ans = new Item765().minSwapsCouples(new int[]{0, 2, 1, 3});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}