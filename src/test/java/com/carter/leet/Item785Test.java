package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item785Test {

    @Test
    void isBipartite() {
        boolean ans = new Item785().isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}