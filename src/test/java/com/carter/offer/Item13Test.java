package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item13Test {

    @Test
    void movingCount() {
        int ans = new Item13().movingCount(2, 3, 1);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void movingCount3() {
        int ans = new Item13().movingCount(38, 15, 9);
        MatcherAssert.assertThat(ans, Matchers.is(135));
    }

    @Test
    void movingCount2() {
        int ans = new Item13().movingCount(16, 8, 4);
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }

    @Test
    void movingCount1() {
        int ans = new Item13().movingCount(3, 1, 0);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}