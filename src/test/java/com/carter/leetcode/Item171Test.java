package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item171Test {
    @Test
    void titleToNumber() {
        int rs = new Item171().titleToNumber("A");
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void titleToNumber3() {
        int rs = new Item171().titleToNumber("Z");
        MatcherAssert.assertThat(rs, Matchers.is(26));
    }

    @Test
    void titleToNumber2() {
        int rs = new Item171().titleToNumber("AZ");
        MatcherAssert.assertThat(rs, Matchers.is(52));
    }

    @Test
    void titleToNumber1() {
        int rs = new Item171().titleToNumber("AB");
        MatcherAssert.assertThat(rs, Matchers.is(28));
    }
}
