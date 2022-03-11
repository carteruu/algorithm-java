package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item495Test {

    @Test
    void findPoisonedDuration() {
        int ans = new Item495().findPoisonedDuration(new int[]{1, 4}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void findPoisonedDuration1() {
        int ans = new Item495().findPoisonedDuration(new int[]{1, 2}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}