package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item76Test {

    @Test
    void minWindow() {
        String res = new Item76().minWindow("ADOBECODEBANC", "ABC");
        MatcherAssert.assertThat(res, Matchers.is("BANC"));
    }

    @Test
    void minWindow3() {
        String res = new Item76().minWindow("ab", "b");
        MatcherAssert.assertThat(res, Matchers.is("b"));
    }

    @Test
    void minWindow2() {
        String res = new Item76().minWindow("a", "a");
        MatcherAssert.assertThat(res, Matchers.is("a"));
    }

    @Test
    void minWindow1() {
        String res = new Item76().minWindow("", "a");
        MatcherAssert.assertThat(res, Matchers.is(""));
    }
}