package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1044Test {

    @Test
    void longestDupSubstring() {
        String ans = new Item1044().longestDupSubstring("banana");
        MatcherAssert.assertThat(ans, Matchers.is("ana"));
    }

    @Test
    void longestDupSubstring2() {
        String ans = new Item1044().longestDupSubstring("abcd");
        MatcherAssert.assertThat(ans, Matchers.is(""));
    }

    @Test
    void longestDupSubstring1() {
        String ans = new Item1044().longestDupSubstring("aa");
        MatcherAssert.assertThat(ans, Matchers.is("a"));
    }
}