package com.carter.leet;

import com.carter.leet.Item2151;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2151Test {

    @Test
    void maximumGood() {
        int ans = new Item2151().maximumGood(new int[][]{{2, 2, 2, 2, 2, 2}, {2, 2, 2, 1, 1, 2}, {2, 2, 2, 2, 2, 2}, {0, 1, 0, 2, 1, 2}, {0, 1, 2, 1, 2, 0}, {0, 0, 1, 0, 2, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void maximumGood3() {
        int ans = new Item2151().maximumGood(new int[][]{{2, 0, 2, 2, 0}, {2, 2, 2, 1, 2}, {2, 2, 2, 1, 2}, {1, 2, 0, 2, 2}, {1, 0, 2, 1, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void maximumGood2() {
        int ans = new Item2151().maximumGood(new int[][]{{2, 1, 2}, {1, 2, 2}, {2, 0, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void maximumGood1() {
        int ans = new Item2151().maximumGood(new int[][]{{2, 0}, {0, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}