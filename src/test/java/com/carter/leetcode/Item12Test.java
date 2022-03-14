package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item12Test {

    @Test
    void intToRoman() {
        String ans = new Item12().intToRoman(3);
        MatcherAssert.assertThat(ans, Matchers.is("III"));
    }

    @Test
    void intToRoman3() {
        String ans = new Item12().intToRoman(4);
        MatcherAssert.assertThat(ans, Matchers.is("IV"));
    }

    @Test
    void intToRoman2() {
        String ans = new Item12().intToRoman(9);
        MatcherAssert.assertThat(ans, Matchers.is("IX"));
    }

    @Test
    void intToRoman1() {
        String ans = new Item12().intToRoman(1994);
        MatcherAssert.assertThat(ans, Matchers.is("MCMXCIV"));
    }
}