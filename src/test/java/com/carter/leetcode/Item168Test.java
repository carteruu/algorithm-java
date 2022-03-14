package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item168Test {

    @Test
    void convertToTitle() {
        String rs = new Item168().convertToTitle(1);
        MatcherAssert.assertThat(rs, Matchers.is("A"));
    }

    @Test
    void convertToTitle3() {
        String rs = new Item168().convertToTitle(26);
        MatcherAssert.assertThat(rs, Matchers.is("Z"));
    }

    @Test
    void convertToTitle2() {
        String rs = new Item168().convertToTitle(701);
        MatcherAssert.assertThat(rs, Matchers.is("ZY"));
    }

    @Test
    void convertToTitle1() {
        String rs = new Item168().convertToTitle(28);
        MatcherAssert.assertThat(rs, Matchers.is("AB"));
    }
}