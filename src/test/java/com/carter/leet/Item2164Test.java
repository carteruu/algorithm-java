package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2164Test {

    @Test
    void sortEvenOdd() {
        int[] ans = new Item2164().sortEvenOdd(new int[]{2});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{2}));
    }

    @Test
    void sortEvenOdd3() {
        int[] ans = new Item2164().sortEvenOdd(new int[]{2, 3, 1, 4});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 4, 2, 3}));
    }

    @Test
    void sortEvenOdd2() {
        int[] ans = new Item2164().sortEvenOdd(new int[]{2, 3, 1});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 3, 2}));
    }

    @Test
    void sortEvenOdd1() {
        int[] ans = new Item2164().sortEvenOdd(new int[]{5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21});
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{5, 45, 9, 39, 12, 33, 14, 30, 20, 27, 21, 25, 30, 15, 32, 14, 33, 5, 44}));
    }
}