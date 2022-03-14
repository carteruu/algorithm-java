package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item149Test {

    @Test
    void maxPoints() {
        int rs = new Item149().maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void maxPoints2() {
        int rs = new Item149().maxPoints(new int[][]{{2, 3}, {3, 3}, {-5, 3}});
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void maxPoints1() {
        int rs = new Item149().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }
}