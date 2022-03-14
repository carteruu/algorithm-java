package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item306Test {

    @Test
    void isAdditiveNumber() {
        boolean ans = new Item306().isAdditiveNumber("123");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isAdditiveNumber2() {
        boolean ans = new Item306().isAdditiveNumber("101");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isAdditiveNumber1() {
        boolean ans = new Item306().isAdditiveNumber("1203");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}