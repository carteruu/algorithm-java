package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1755Test {

    @Test
    void minAbsDifference() {
        int ans = new Item1755().minAbsDifference(new int[]{5, -7, 3, 5}, 6);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}