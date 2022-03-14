package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class Item14Test {

    @Test
    void longestCommonPrefix() {
        String rs = new Item14().longestCommonPrefix(new String[]{"a"});
        MatcherAssert.assertThat(rs, is("a"));
    }

    @Test
    void longestCommonPrefix1() {
        String rs = new Item14().longestCommonPrefix(new String[]{"a", "ab"});
        MatcherAssert.assertThat(rs, is("a"));
    }

    @Test
    void longestCommonPrefix2() {
        String rs = new Item14().longestCommonPrefix(new String[]{""});
        MatcherAssert.assertThat(rs, is(""));
    }
}