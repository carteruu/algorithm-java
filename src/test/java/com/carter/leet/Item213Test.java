package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item213Test {

    @Test
    void rob() {
        int ans = new Item213().rob(new int[]{2, 3, 2});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void rob2() {
        int ans = new Item213().rob(new int[]{1, 2, 3, 1});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void rob1() {
        int ans = new Item213().rob(new int[]{});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}