package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item59_2Test {

    @Test
    void generateMatrix() {
        int[][] ans = new Item59_2().generateMatrix(3);
        MatcherAssert.assertThat(ans[0][0], Matchers.is(1));
        MatcherAssert.assertThat(ans[0][2], Matchers.is(3));
        MatcherAssert.assertThat(ans[2][2], Matchers.is(5));
        MatcherAssert.assertThat(ans[2][0], Matchers.is(7));
        MatcherAssert.assertThat(ans[1][1], Matchers.is(9));
    }

    @Test
    void generateMatrix1() {
        int[][] ans = new Item59_2().generateMatrix(2);
        MatcherAssert.assertThat(ans[0][0], Matchers.is(1));
        MatcherAssert.assertThat(ans[1][1], Matchers.is(3));
    }
}