package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item96Test {

    @Test
    void numTrees() {
        int rs = new Item96().numTrees(3);
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }
}