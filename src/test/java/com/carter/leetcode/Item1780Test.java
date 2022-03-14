package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1780Test {

    @Test
    void checkPowersOfThree() {
        boolean rs = new Item1780().checkPowersOfThree(12);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkPowersOfThree4() {
        boolean rs = new Item1780().checkPowersOfThree(6);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkPowersOfThree3() {
        boolean rs = new Item1780().checkPowersOfThree(9565938);
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }

    @Test
    void checkPowersOfThree2() {
        boolean rs = new Item1780().checkPowersOfThree(91);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkPowersOfThree1() {
        boolean rs = new Item1780().checkPowersOfThree(21);
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }
}