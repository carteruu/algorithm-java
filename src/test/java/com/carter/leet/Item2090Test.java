package com.carter.leet;

import com.carter.leet.Item2090;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2090Test {
    @Test
    void test() {
        int[] ans = new Item2090().getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1}));
    }

    @Test
    void test2() {
        int[] ans = new Item2090().getAverages(new int[]{1}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{-1}));
    }
}