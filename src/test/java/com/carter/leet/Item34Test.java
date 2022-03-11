package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item34Test {
    @Test
    void searchRange() {
        int[] rs = new Item34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        MatcherAssert.assertThat(rs, Matchers.is(new int[]{3, 4}));
    }
}
