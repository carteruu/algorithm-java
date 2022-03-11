package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1370Test {

    @Test
    void sortString() {
        String rs = new Item1370().sortString("aaaabbbbcccc");
        MatcherAssert.assertThat(rs, Matchers.is("abccbaabccba"));
    }
}