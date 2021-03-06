package com.carter.lcp;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item07Test {
    @Test
    public void numWays() {
        int rs = new Item07().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }
}
