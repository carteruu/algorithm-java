package com.carter.leet;

import com.carter.leet.Item2161;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2161Test {
    @Test
    void pivotArray() {
        int[] ans = new Item2161().pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{9, 5, 3, 10, 10, 12, 14}));
    }
}