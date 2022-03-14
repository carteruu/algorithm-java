package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item58Test {

    @Test
    void lengthOfLastWord() {
        int len = new Item58().lengthOfLastWord(" ");
        MatcherAssert.assertThat(len, Matchers.is(0));
    }

    @Test
    void lengthOfLastWord2() {
        int len = new Item58().lengthOfLastWord("          ");
        MatcherAssert.assertThat(len, Matchers.is(0));
    }

    @Test
    void lengthOfLastWord1() {
        int len = new Item58().lengthOfLastWord("Hello World  ");
        MatcherAssert.assertThat(len, Matchers.is(5));
    }
}