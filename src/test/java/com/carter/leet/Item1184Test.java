package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1184Test {

    @Test
    void distanceBetweenBusStops() {
        int rs = new Item1184().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void distanceBetweenBusStops2() {
        int rs = new Item1184().distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2);
        MatcherAssert.assertThat(rs, Matchers.is(17));
    }

    @Test
    void distanceBetweenBusStops1() {
        int rs = new Item1184().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3);
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }
}