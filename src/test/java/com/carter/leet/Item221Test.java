package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item221Test {

    @Test
    void maximalSquare() {
        int ans = new Item221().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void maximalSquare3() {
        int ans = new Item221().maximalSquare(new char[][]{{'1', '1'}, {'1', '1'}});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void maximalSquare2() {
        int ans = new Item221().maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void maximalSquare1() {
        int ans = new Item221().maximalSquare(new char[][]{{'0'}});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}