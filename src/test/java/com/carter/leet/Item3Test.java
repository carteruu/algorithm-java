package com.carter.leet;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class Item3Test {
    @Test
    void lengthOfLongestSubstring() {
        int count = new Item3().lengthOfLongestSubstring("abcabcbb");
        assertThat(count, is(3));
    }

    @Test
    void lengthOfLongestSubstring1() {
        int count = new Item3().lengthOfLongestSubstring("bbbbb");
        assertThat(count, is(1));
    }

    @Test
    void lengthOfLongestSubstring2() {
        int count = new Item3().lengthOfLongestSubstring("pwwkew");
        assertThat(count, is(3));
    }

    @Test
    void lengthOfLongestSubstring3() {
        int count = new Item3().lengthOfLongestSubstring("a");
        assertThat(count, is(1));
    }

    @Test
    void lengthOfLongestSubstring4() {
        int count = new Item3().lengthOfLongestSubstring("abba");
        assertThat(count, is(2));
    }
}
