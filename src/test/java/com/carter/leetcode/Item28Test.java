package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item28Test {

    @Test
    void strStr() {
        int idx = new Item28().strStr("hello", "ll");
        MatcherAssert.assertThat(idx, Matchers.is(2));
    }

    @Test
    void strStr1() {
        int idx = new Item28().strStr("mississippi", "mississippi");
        MatcherAssert.assertThat(idx, Matchers.is(0));
    }@Test
    void strStr2() {
        int idx = new Item28().strStr("a", "a");
        MatcherAssert.assertThat(idx, Matchers.is(0));
    }
}