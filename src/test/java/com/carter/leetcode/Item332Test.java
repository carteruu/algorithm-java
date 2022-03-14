package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item332Test {
    @Test
    void findItinerary() {
        List<String> ans = new Item332().findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")));
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC")));
    }
}