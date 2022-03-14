package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1449Test {
    @Test
    void largestNumber() {
        String rs = new Item1449().largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9);
        MatcherAssert.assertThat(rs, Matchers.is("7772"));
    }

    @Test
    void largestNumber4() {
        String rs = new Item1449().largestNumber(new int[]{37, 84, 69, 42, 86, 49, 45, 38, 81}, 627);
        MatcherAssert.assertThat(rs, Matchers.is("8888888888888644"));
    }

    @Test
    void largestNumber3() {
        String rs = new Item1449().largestNumber(new int[]{13, 12, 9, 12, 15, 11, 10, 11, 15}, 52);
        MatcherAssert.assertThat(rs, Matchers.is("97333"));
    }

    @Test
    void largestNumber2() {
        String rs = new Item1449().largestNumber(new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4}, 5);
        MatcherAssert.assertThat(rs, Matchers.is("0"));
    }

    @Test
    void largestNumber1() {
        String rs = new Item1449().largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12);
        MatcherAssert.assertThat(rs, Matchers.is("85"));
    }
}