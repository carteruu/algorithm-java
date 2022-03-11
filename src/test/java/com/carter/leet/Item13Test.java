package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item13Test {

    @Test
    void romanToInt() {
        int rs = new Item13().romanToInt("MCMXCIV");
        MatcherAssert.assertThat(rs, Matchers.is(1994));
    }
}