package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item331Test {

    @Test
    void isValidSerialization() {
        boolean rs = new Item331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void isValidSerialization2() {
        boolean rs = new Item331().isValidSerialization("9,#,#,1");
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }

    @Test
    void isValidSerialization1() {
        boolean rs = new Item331().isValidSerialization("1,#");
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }
}