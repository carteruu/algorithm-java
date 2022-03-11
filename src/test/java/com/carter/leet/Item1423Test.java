package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1423Test {

    @Test
    void maxScore() {
        int sum = new Item1423().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        MatcherAssert.assertThat(sum, Matchers.is(12));
    }

    @Test
    void maxScore1() {
        int sum = new Item1423().maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7);
        MatcherAssert.assertThat(sum, Matchers.is(55));
    }
}