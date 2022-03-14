package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2024Test {

    @Test
    void maxConsecutiveAnswers() {
        int ans = new Item2024().maxConsecutiveAnswers("TTFF", 2);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void maxConsecutiveAnswers1() {
        int ans = new Item2024().maxConsecutiveAnswers("TFFT", 1);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void maxConsecutiveAnswers2() {
        int ans = new Item2024().maxConsecutiveAnswers("TTFTTFTT", 1);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}