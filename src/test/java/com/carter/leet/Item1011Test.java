package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1011Test {

    @Test
    void shipWithinDays() {
        int ans = new Item1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }

    @Test
    void shipWithinDays1() {
        int ans = new Item1011().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }
}