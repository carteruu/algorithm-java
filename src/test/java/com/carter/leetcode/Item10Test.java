package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item10Test {

    @Test
    void isMatch() {
        boolean ans = new Item10().isMatch("ab", ".*");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isMatch5() {
        boolean ans = new Item10().isMatch("ab", "ab.*");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isMatch4() {
        boolean ans = new Item10().isMatch("", "");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isMatch3() {
        boolean ans = new Item10().isMatch("aab", "c*a*b");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isMatch2() {
        boolean ans = new Item10().isMatch("mississippi", "mis*is*p*.");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void isMatch1() {
        boolean ans = new Item10().isMatch("ab", "");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}