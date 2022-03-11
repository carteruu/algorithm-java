package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item84Test {

    @Test
    void largestRectangleArea() {
        int ans = new Item84().largestRectangleArea(new int[]{});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void largestRectangleArea2() {
        int ans = new Item84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        MatcherAssert.assertThat(ans, Matchers.is(10));
    }

    @Test
    void largestRectangleArea3() {
        int ans = new Item84().largestRectangleArea(new int[]{2, 4});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

}