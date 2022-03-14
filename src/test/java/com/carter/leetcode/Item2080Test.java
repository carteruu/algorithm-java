package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2080Test {
    @Test
    void RangeFreqQuery() {
        Item2080.RangeFreqQuery rangeFreqQuery = new Item2080.RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
        MatcherAssert.assertThat(rangeFreqQuery.query(6, 8, 4), Matchers.is(0));
    }

    @Test
    void RangeFreqQuery2() {
        Item2080.RangeFreqQuery rangeFreqQuery = new Item2080.RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        MatcherAssert.assertThat(rangeFreqQuery.query(1, 2, 4), Matchers.is(1));
        MatcherAssert.assertThat(rangeFreqQuery.query(0, 11, 33), Matchers.is(2));
    }

    @Test
    void RangeFreqQuery1() {
        Item2080.RangeFreqQuery rangeFreqQuery = new Item2080.RangeFreqQuery(new int[]{4, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        MatcherAssert.assertThat(rangeFreqQuery.query(1, 2, 4), Matchers.is(1));
    }
}