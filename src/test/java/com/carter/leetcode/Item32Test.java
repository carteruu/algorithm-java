package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item32Test {

    @Test
    void longestValidParentheses() {
        int ans = new Item32().longestValidParentheses("(()");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void longestValidParentheses4() {
        int ans = new Item32().longestValidParentheses("(()))");
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void longestValidParentheses3() {
        int ans = new Item32().longestValidParentheses("()(())((()))(()(()");
        MatcherAssert.assertThat(ans, Matchers.is(12));
    }

    @Test
    void longestValidParentheses2() {
        int ans = new Item32().longestValidParentheses(")()())");
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void longestValidParentheses1() {
        int ans = new Item32().longestValidParentheses("");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}