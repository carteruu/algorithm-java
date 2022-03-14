package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item753Test {

    @Test
    void crackSafe() {
        String ans = new Item753().crackSafe(2, 2);
        MatcherAssert.assertThat(ans, Matchers.is("00110"));
    }
}