package com.carter.js;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2170Test {

    @Test
    void minimumOperations() {
        int ans = new Item2170().minimumOperations(new int[]{3, 1, 3, 2, 4, 3});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void minimumOperations6() {
        int ans = new Item2170().minimumOperations(new int[]{68, 68, 24, 100, 85, 7, 96, 64, 91, 95, 75, 59, 4, 67, 63, 70, 97, 84, 94, 46, 95, 72, 73, 83, 33, 34, 9, 91, 17, 8, 22, 41, 11, 25, 57, 70, 33, 7, 71, 20, 55, 45, 78, 92, 6, 56, 37, 95, 20, 8, 82, 60, 45, 49, 9, 27, 46, 85, 87, 83, 77, 34, 92, 28, 25, 18, 62, 51, 79, 55, 71, 33, 21, 29, 92, 43, 51});
        MatcherAssert.assertThat(ans, Matchers.is(73));
    }

    @Test
    void minimumOperations5() {
        int ans = new Item2170().minimumOperations(new int[]{1});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void minimumOperations4() {
        int ans = new Item2170().minimumOperations(new int[]{1, 2});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void minimumOperations3() {
        int ans = new Item2170().minimumOperations(new int[]{1, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void minimumOperations2() {
        int ans = new Item2170().minimumOperations(new int[]{1, 2, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void minimumOperations1() {
        int ans = new Item2170().minimumOperations(new int[]{1, 2, 2, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}