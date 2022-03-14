package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item179Test {

    @Test
    void largestNumber() {
        String res = new Item179().largestNumber(new int[]{10, 2});
        MatcherAssert.assertThat(res, Matchers.is("210"));
    }

    @Test
    void largestNumber4() {
        String res = new Item179().largestNumber(new int[]{0, 0});
        MatcherAssert.assertThat(res, Matchers.is("0"));
    }

    @Test
    void largestNumber3() {
        String res = new Item179().largestNumber(new int[]{432, 43243});
        MatcherAssert.assertThat(res, Matchers.is("43243432"));
    }

    @Test
    void largestNumber2() {
        String res = new Item179().largestNumber(new int[]{3, 30, 34, 5, 9});
        MatcherAssert.assertThat(res, Matchers.is("9534330"));
    }

    @Test
    void largestNumber1() {
        String res = new Item179().largestNumber(new int[]{1});
        MatcherAssert.assertThat(res, Matchers.is("1"));
    }
}