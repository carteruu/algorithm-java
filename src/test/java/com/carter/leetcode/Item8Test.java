package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item8Test {

    @Test
    void myAtoi() {
        int ans = new Item8().myAtoi("1");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void myAtoi6() {
        int ans = new Item8().myAtoi("-+1");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void myAtoi5() {
        int ans = new Item8().myAtoi("-1");
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void myAtoi4() {
        int ans = new Item8().myAtoi("   -42");
        MatcherAssert.assertThat(ans, Matchers.is(-42));
    }

    @Test
    void myAtoi3() {
        int ans = new Item8().myAtoi("4193 with words");
        MatcherAssert.assertThat(ans, Matchers.is(4193));
    }

    @Test
    void myAtoi2() {
        int ans = new Item8().myAtoi("words and 987");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void myAtoi1() {
        int ans = new Item8().myAtoi("-91283472332");
        MatcherAssert.assertThat(ans, Matchers.is(-2147483648));
    }
}