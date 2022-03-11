package com.carter.leet;

import com.carter.leet.Item2070;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2070Test {

    @Test
    void maximumBeauty() {
        int[] ans = new Item2070().maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{2, 4, 5, 5, 6, 6}));
    }

    @Test
    void maximumBeauty2() {
        int[] ans = new Item2070().maximumBeauty(new int[][]{{1, 2}, {1, 2}, {1, 3}, {1, 4}}, new int[]{1});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{4}));
    }

    @Test
    void maximumBeauty1() {
        int[] ans = new Item2070().maximumBeauty(new int[][]{{10, 1000}}, new int[]{5});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0}));
    }
}