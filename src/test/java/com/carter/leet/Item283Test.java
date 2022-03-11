package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item283Test {

    @Test
    void moveZeroes() {
        int[] ans = {0, 0, 1, 3, 12};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 3, 12, 0, 0}));
    }

    @Test
    void moveZeroes5() {
        int[] ans = {0, 1, 0, 3, 12};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 3, 12, 0, 0}));
    }

    @Test
    void moveZeroes4() {
        int[] ans = {1, 3, 12};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 3, 12}));
    }

    @Test
    void moveZeroes3() {
        int[] ans = {0, 0};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{0, 0}));
    }

    @Test
    void moveZeroes2() {
        int[] ans = {};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{}));
    }

    @Test
    void moveZeroes1() {
        int[] ans = {0, 0, 1, 3, 12, 0};
        new Item283().moveZeroes(ans);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 3, 12, 0, 0, 0}));
    }
}