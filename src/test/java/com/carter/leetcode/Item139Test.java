package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Item139Test {
    @Test
    void wordBreak() {
        boolean ans = new Item139_1().wordBreak("leetcode", Arrays.asList("leet", "code"));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void wordBreak7() {
        boolean ans = new Item139_1().wordBreak("paviraagi", Arrays.asList("pavira", "pavi", "raa", "gi", "ag", "ii"));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void wordBreak6() {
        boolean ans = new Item139_1().wordBreak("leetCode", Arrays.asList("leet", "code"));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void wordBreak5() {
        boolean ans = new Item139_1().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void wordBreak4() {
        boolean ans = new Item139_1().wordBreak("lee", Arrays.asList("le", "lee"));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void wordBreak3() {
        boolean ans = new Item139_1().wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void wordBreak2() {
        boolean ans = new Item139().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void wordBreak1() {
        boolean ans = new Item139().wordBreak("leecode", Arrays.asList("leet", "code"));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}