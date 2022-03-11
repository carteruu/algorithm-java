package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item410Test {

    @Test
    void splitArray() {
        int ans = new Item410().splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(18));
    }

    @Test
    void splitArray3() {
        int ans = new Item410().splitArray(new int[]{7, 6, 5, 4, 3, 2, 1}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }

    @Test
    void splitArray2() {
        int ans = new Item410().splitArray(new int[]{1, 2, 3, 4, 5}, 2);
        MatcherAssert.assertThat(ans, Matchers.is(9));
    }

    @Test
    void splitArray1() {
        int ans = new Item410().splitArray(new int[]{1, 4, 4}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}