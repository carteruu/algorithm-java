package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item27Test {

    @Test
    void removeElement() {
        int len = new Item27().removeElement(new int[]{3, 2, 2, 3}, 3);
        MatcherAssert.assertThat(len, Matchers.is(2));
    }
}