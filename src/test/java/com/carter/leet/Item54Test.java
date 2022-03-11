package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item54Test {

    @Test
    void spiralOrder() {
        List<Integer> res = new Item54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        MatcherAssert.assertThat(res, Matchers.is(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
    }

    @Test
    void spiralOrder3() {
        List<Integer> res = new Item54().spiralOrder(new int[][]{{}, {}, {}});
        MatcherAssert.assertThat(res, Matchers.is(new ArrayList<>()));
    }

    @Test
    void spiralOrder2() {
        List<Integer> res = new Item54().spiralOrder(new int[][]{});
        MatcherAssert.assertThat(res, Matchers.is(new ArrayList<>()));
    }

    @Test
    void spiralOrder1() {
        List<Integer> res = new Item54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        MatcherAssert.assertThat(res, Matchers.is(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)));
    }
}