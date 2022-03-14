package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item152Test {

    @Test
    void maxProduct() {
        int ans = new Item152().maxProduct(new int[]{2, 3, -2, 4});
        MatcherAssert.assertThat(ans, Matchers.is(6));
    }

    @Test
    void maxProduct4() {
        int ans = new Item152().maxProduct(new int[]{-6, 9, -2, 3, -2, 4, -2, -10});
        MatcherAssert.assertThat(ans, Matchers.is(8640));
    }

    @Test
    void maxProduct3() {
        int ans = new Item152().maxProduct(new int[]{-3, 0, 1, -2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void maxProduct2() {
        int ans = new Item152().maxProduct(new int[]{-2});
        MatcherAssert.assertThat(ans, Matchers.is(-2));
    }

    @Test
    void maxProduct1() {
        int ans = new Item152().maxProduct(new int[]{-2, 0, -1});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}