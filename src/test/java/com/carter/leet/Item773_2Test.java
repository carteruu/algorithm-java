package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item773_2Test {

    @Test
    void slidingPuzzle() {
        int rs = new Item773_2_1().slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void slidingPuzzle2() {
        int rs = new Item773_2_1().slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}});
        MatcherAssert.assertThat(rs, Matchers.is(14));
    }

    @Test
    void slidingPuzzle1() {
        int rs = new Item773_2_1().slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}});
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }
}