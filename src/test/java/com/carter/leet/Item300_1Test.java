package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item300_1Test {

    @Test
    void lengthOfLIS() {
        int ans = new Item300_1().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}