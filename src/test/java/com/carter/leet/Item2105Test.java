package com.carter.leet;

import com.carter.leet.Item2105;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2105Test {
    @Test
    void test() {
        int ans = new Item2105().minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void test3() {
        int ans = new Item2105().minimumRefill(new int[]{2, 2, 3, 3}, 3, 4);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void test2() {
        int ans = new Item2105().minimumRefill(new int[]{5}, 10, 8);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void test1() {
        int ans = new Item2105().minimumRefill(new int[]{2, 2, 5, 2, 2}, 5, 5);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}