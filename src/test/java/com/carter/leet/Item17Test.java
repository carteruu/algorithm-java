package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item17Test {

    @Test
    void letterCombinations() {
        List<String> ans = new Item17().letterCombinations("23");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }

    @Test
    void letterCombinations2() {
        List<String> ans = new Item17().letterCombinations("");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList()));
    }

    @Test
    void letterCombinations1() {
        List<String> ans = new Item17().letterCombinations("2");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("a", "b", "c")));
    }
}