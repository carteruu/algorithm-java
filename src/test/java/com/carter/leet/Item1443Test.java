package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Item1443Test {

    @Test
    void minTime() {
        int rs = new Item1443().minTime(7,
                new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 6}},
                Arrays.asList(false, false, true, false, true, true, false));
        MatcherAssert.assertThat(rs, Matchers.is(8));
    }

    @Test
    void minTime4() {
        int rs = new Item1443().minTime(4,
                new int[][]{new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2}},
                Arrays.asList(false, true, false, false));
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }

    @Test
    void minTime3() {
        int rs = new Item1443().minTime(5,
                new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 4}},
                Arrays.asList(true, false, false, false, true));
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }

    @Test
    void minTime2() {
        int rs = new Item1443().minTime(3,
                new int[][]{new int[]{0, 1}, new int[]{0, 2}},
                Arrays.asList(true, false, false));
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void minTime1() {
        int rs = new Item1443().minTime(3,
                new int[][]{new int[]{0, 1}, new int[]{0, 2}},
                Arrays.asList(false, true, true));
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }
}