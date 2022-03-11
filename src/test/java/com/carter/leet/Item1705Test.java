package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1705Test {
    @Test
    void eatenApples() {
        int ans = new Item1705().eatenApples(
                new int[]{1},
                new int[]{1});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void eatenApples9() {
        int ans = new Item1705().eatenApples(
                new int[]{2, 1, 10},
                new int[]{2, 10, 1});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void eatenApples8() {
        int ans = new Item1705().eatenApples(
                new int[]{1, 10, 17, 10, 12, 6, 20, 8, 8, 22, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 5, 2, 1, 0, 0, 0, 0, 0, 0, 23},
                new int[]{19999, 11, 18, 22, 5, 2, 14, 5, 20, 7, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1, 4, 2, 7, 0, 0, 0, 0, 0, 0, 1});
        MatcherAssert.assertThat(ans, Matchers.is(37));
    }

    @Test
    void eatenApples7() {
        int ans = new Item1705().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }

    @Test
    void eatenApples6() {
        int ans = new Item1705().eatenApples(new int[]{1}, new int[]{0});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void eatenApples5() {
        int ans = new Item1705().eatenApples(new int[]{3, 1, 0, 0, 3, 2}, new int[]{3, 0, 0, 0, 3, 2});
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void eatenApples4() {
        int ans = new Item1705().eatenApples(new int[]{3, 1, 0, 3, 0, 2}, new int[]{3, 0, 0, 3, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }

    @Test
    void eatenApples3() {
        int ans = new Item1705().eatenApples(new int[]{3, 1, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void eatenApples2() {
        int ans = new Item1705().eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void eatenApples1() {
        int ans = new Item1705().eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}