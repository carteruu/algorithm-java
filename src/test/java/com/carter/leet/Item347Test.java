package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item347Test {

    @Test
    void topKFrequent() {
        int[] ans = new Item347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 2}));
    }

    @Test
    void topKFrequent2() {
        int[] ans = new Item347().topKFrequent(new int[]{1, 2}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{2, 1}));
    }

    @Test
    void topKFrequent1() {
        int[] ans = new Item347().topKFrequent(new int[]{1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1}));
    }
}