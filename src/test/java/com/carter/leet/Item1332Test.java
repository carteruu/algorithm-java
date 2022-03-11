package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1332Test {

    @Test
    void removePalindromeSub() {
        int ans = new Item1332().removePalindromeSub("aabababaaababaab");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}