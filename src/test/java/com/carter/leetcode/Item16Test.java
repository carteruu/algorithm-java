package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item16Test {
    @Test
    void threeSumClosest() {
        int res = new Item16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        MatcherAssert.assertThat(res, Matchers.is(2));
    }
}
