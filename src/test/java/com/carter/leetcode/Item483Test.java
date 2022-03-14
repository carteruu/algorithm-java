package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item483Test {

    @Test
    void smallestGoodBase() {
        String s = new Item483().smallestGoodBase("13");
        MatcherAssert.assertThat(s, Matchers.is("3"));
    }

    @Test
    void smallestGoodBase2() {
        String s = new Item483().smallestGoodBase("4681");
        MatcherAssert.assertThat(s, Matchers.is("8"));
    }

    @Test
    void smallestGoodBase1() {
        String s = new Item483().smallestGoodBase("1000000000000000000");
        MatcherAssert.assertThat(s, Matchers.is("999999999999999999"));
    }
}