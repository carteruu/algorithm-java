package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item131Test {

    @Test
    void partition() {
        List<List<String>> ans = new Item131().partition("aab");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"))));
    }

    @Test
    void partition3() {
        List<List<String>> ans = new Item131().partition("");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList())));
    }

    @Test
    void partition2() {
        List<List<String>> ans = new Item131().partition("aab");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"))));
    }

    @Test
    void partition1() {
        List<List<String>> ans = new Item131().partition("a");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList("a"))));
    }
}