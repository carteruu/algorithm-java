package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item525Test {

    @Test
    void findMaxLength() {
        int maxLength = new Item525().findMaxLength(new int[]{0, 1});
        MatcherAssert.assertThat(maxLength, Matchers.is(2));
    }

    @Test
    void findMaxLength2() {
        int maxLength = new Item525().findMaxLength(new int[]{0, 0, 1});
        MatcherAssert.assertThat(maxLength, Matchers.is(2));
    }

    @Test
    void findMaxLength1() {
        int maxLength = new Item525().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1});
        MatcherAssert.assertThat(maxLength, Matchers.is(6));
    }
}