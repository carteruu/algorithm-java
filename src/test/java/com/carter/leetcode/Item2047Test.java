package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2047Test {

    @Test
    void countValidWords() {
        int ans = new Item2047().countValidWords("!");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void countValidWords3() {
        int ans = new Item2047().countValidWords("cat and  dog");
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void countValidWords2() {
        int ans = new Item2047().countValidWords("cat-and  dog");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void countValidWords1() {
        int ans = new Item2047().countValidWords("!this  1-s b8d!");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}