package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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