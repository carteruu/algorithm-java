package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item85Test {
    @Test
    void maximalRectangle() {
        int ans = new Item85().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void maximalRectangle5() {
        int ans = new Item85().maximalRectangle(new char[][]{{'0', '1'}, {'0', '1'}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void maximalRectangle4() {
        int ans = new Item85().maximalRectangle(new char[][]{});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void maximalRectangle3() {
        int ans = new Item85().maximalRectangle(new char[][]{{}});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void maximalRectangle2() {
        int ans = new Item85().maximalRectangle(new char[][]{{'1', '0'}, {'0', '1'}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void maximalRectangle1() {
        int ans = new Item85().maximalRectangle(new char[][]{{'1', '1'}, {'1', '1'}});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}
