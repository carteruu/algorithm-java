package com.carter.leet;

import com.carter.leet.Item2110;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2110Test {

    @Test
    void getDescentPeriods() {
        long ans = new Item2110().getDescentPeriods(new int[]{4, 3, 2, 1});
        MatcherAssert.assertThat(ans, Matchers.is(4L));
    }

    @Test
    void getDescentPeriods4() {
        long ans = new Item2110().getDescentPeriods(new int[]{1, 2, 3, 4});
        MatcherAssert.assertThat(ans, Matchers.is(4L));
    }

    @Test
    void getDescentPeriods3() {
        long ans = new Item2110().getDescentPeriods(new int[]{8, 6, 7, 7});
        MatcherAssert.assertThat(ans, Matchers.is(4L));
    }

    @Test
    void getDescentPeriods2() {
        long ans = new Item2110().getDescentPeriods(new int[]{1});
        MatcherAssert.assertThat(ans, Matchers.is(1L));
    }

    @Test
    void getDescentPeriods1() {
        long ans = new Item2110().getDescentPeriods(new int[]{3, 2, 1, 4});
        MatcherAssert.assertThat(ans, Matchers.is(7L));
    }
}