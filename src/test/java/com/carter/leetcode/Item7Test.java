package com.carter.leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Item7Test {
    @Test
    void lengthOfLongestSubstring() {
        int rs = new Item7().reverse(123);
        assertThat(rs, is(321));
    }

    @Test
    void lengthOfLongestSubstring1() {
        int rs = new Item7().reverse(-123);
        assertThat(rs, is(-321));
    }

    @Test
    void lengthOfLongestSubstring2() {
        int rs = new Item7().reverse(120);
        assertThat(rs, is(21));
    }

    @Test
    void lengthOfLongestSubstring3() {
        int rs = new Item7().reverse(0);
        assertThat(rs, is(0));
    }

    @Test
    void lengthOfLongestSubstring4() {
        int rs = new Item7().reverse(1534236469);
        assertThat(rs, is(0));
    }

    @Test
    void lengthOfLongestSubstring7() {
        int rs = new Item7().reverse(Integer.MIN_VALUE + 7);
        assertThat(rs, is(-1463847412));
    }

    @Test
    void lengthOfLongestSubstring6() {
        int rs = new Item7().reverse(Integer.MAX_VALUE - 6);
        assertThat(rs, is(1463847412));
    }
}
