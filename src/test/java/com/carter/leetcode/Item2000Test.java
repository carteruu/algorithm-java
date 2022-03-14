package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2000Test {

    @Test
    void reversePrefix() {
        String ans = new Item2000().reversePrefix("abcdefd", 'd');
        MatcherAssert.assertThat(ans, Matchers.is("dcbaefd"));
    }

    @Test
    void reversePrefix1() {
        String ans = new Item2000().reversePrefix("abcd", 'z');
        MatcherAssert.assertThat(ans, Matchers.is("abcd"));
    }
}