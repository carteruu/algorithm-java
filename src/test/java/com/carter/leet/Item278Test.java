package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item278Test {

    @Test
    void firstBadVersion() {
        int res = new Item278().firstBadVersion(8);
        MatcherAssert.assertThat(res, Matchers.is(4));
    }
}