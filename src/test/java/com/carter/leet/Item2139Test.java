package com.carter.leet;

import com.carter.leet.Item2139;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2139Test {

    @Test
    void minMoves() {
        int ans = new Item2139().minMoves(19, 2);
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }@Test
    void minMoves1() {
        int ans = new Item2139().minMoves(2, 1);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}