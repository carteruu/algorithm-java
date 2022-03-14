package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2071Test {

    @Test
    void maxTaskAssign() {
        int ans = new Item2071().maxTaskAssign(new int[]{5, 4}, new int[]{0, 0, 0}, 1, 5);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void maxTaskAssign1() {
        int ans = new Item2071().maxTaskAssign(new int[]{3, 2, 1}, new int[]{0, 3, 3}, 1, 1);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}