package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1996Test {

    @Test
    void numberOfWeakCharacters() {
        int ans = new Item1996().numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void numberOfWeakCharacters3() {
        int ans = new Item1996().numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void numberOfWeakCharacters2() {
        int ans = new Item1996().numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void numberOfWeakCharacters1() {
        int ans = new Item1996().numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}