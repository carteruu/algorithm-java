package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item773Test {
    @Test
    void slidingPuzzle() {
        int rs = new Item773_3().slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}});
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }

    @Test
    void slidingPuzzle2() {
        int rs = new Item773_3().slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void slidingPuzzle1() {
        int rs = new Item773_3().slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}});
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }
}