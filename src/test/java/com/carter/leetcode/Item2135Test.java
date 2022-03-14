package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2135Test {
    @Test
    void wordCount() {
        int ans = new Item2135().wordCount(new String[]{"ant", "act", "tack"}, new String[]{"tack", "act", "acti"});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void wordCount1() {
        int ans = new Item2135().wordCount(new String[]{"ab", "a"}, new String[]{"abc", "abcd"});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}