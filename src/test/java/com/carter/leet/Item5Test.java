package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item5Test {

    @Test
    void longestPalindrome() {
        String s = new Item5().longestPalindrome("aba");
        MatcherAssert.assertThat(s, Matchers.is("aba"));
    }

    @Test
    void longestPalindrome3() {
        String s = new Item5().longestPalindrome("aaaa");
        MatcherAssert.assertThat(s, Matchers.is("aaaa"));
    }

    @Test
    void longestPalindrome2() {
        String s = new Item5().longestPalindrome("cbbd");
        MatcherAssert.assertThat(s, Matchers.is("bb"));
    }

    @Test
    void longestPalindrome1() {
        String s = new Item5().longestPalindrome("babad");
        MatcherAssert.assertThat(s, Matchers.is("bad"));
    }
}