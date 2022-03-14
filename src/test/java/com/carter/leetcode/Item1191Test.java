package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1191Test {

    @Test
    void kConcatenationMaxSum() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{1, 2}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(9));
    }

    @Test
    void kConcatenationMaxSum5() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{-5, 4, -4, -3, 5, -3}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }

    @Test
    void kConcatenationMaxSum4() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{1, -1}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void kConcatenationMaxSum3() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{1, 2}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void kConcatenationMaxSum2() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{-1, -2}, 7);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void kConcatenationMaxSum1() {
        int rs = new Item1191().kConcatenationMaxSum(new int[]{1, -2, 1}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }
}