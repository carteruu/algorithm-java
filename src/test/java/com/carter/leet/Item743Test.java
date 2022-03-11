package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item743Test {
    @Test
    void networkDelayTime() {
        int ans = new Item743().networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}