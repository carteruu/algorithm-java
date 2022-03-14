package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item859Test {

    @Test
    void buddyStrings() {
        boolean rs = new Item859().buddyStrings("ab", "ba");
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }@Test
    void buddyStrings1() {
        boolean rs = new Item859().buddyStrings("aa", "aa");
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }
}