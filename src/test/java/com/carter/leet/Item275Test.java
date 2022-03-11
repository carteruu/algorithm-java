package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item275Test {

    @Test
    void hIndex() {
        int rs = new Item275().hIndex(new int[]{0, 1, 3, 5, 6});
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }
}