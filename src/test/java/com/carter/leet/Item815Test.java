package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item815Test {

    @Test
    void numBusesToDestination() {
        int rs = new Item815_5().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void numBusesToDestination3() {
        int rs = new Item815_5().numBusesToDestination(new int[][]{{0, 1, 6, 16, 22, 23}, {14, 15, 24, 32}, {4, 10, 12, 20, 24, 28, 33}, {1, 10, 11, 19, 27, 33}, {11, 23, 25, 28}, {15, 20, 21, 23, 29}, {29}}, 4, 21);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void numBusesToDestination2() {
        int rs = new Item815_5().numBusesToDestination(new int[][]{{2}, {2, 8}}, 8, 2);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }


    @Test
    void numBusesToDestination1() {
        int rs = new Item815_5().numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }
}