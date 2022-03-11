package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item704Test {

    @Test
    void search() {
        int ans = new Item704().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void search3() {
        int ans = new Item704().search(new int[]{}, 9);
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void search2() {
        int ans = new Item704().search(new int[]{1}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void search1() {
        int ans = new Item704().search(new int[]{1}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }
}