package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item2033Test {

    @Test
    void minOperations() {
        int ans = new Item2033().minOperations(new int[][]{{931, 128}, {639, 712}}, 73);
        MatcherAssert.assertThat(ans, Matchers.is(12));
    }

    @Test
    void minOperations1() {
        int ans = new Item2033().minOperations(new int[][]{{529, 529, 989}, {989, 529, 345}, {989, 805, 69}}, 92);
        MatcherAssert.assertThat(ans, Matchers.is(25));
    }
}