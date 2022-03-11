package com.carter.leet;

import com.carter.leet.Item2140;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2140Test {

    @Test
    void mostPoints() {
        long ans = new Item2140().mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}});
        MatcherAssert.assertThat(ans, Matchers.is(7L));
    }
}