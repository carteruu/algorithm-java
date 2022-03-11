package com.carter.leet;

import com.carter.leet.Item2063;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2063Test {

    @Test
    void countVowels() {
        long ans = new Item2063().countVowels("a");
        MatcherAssert.assertThat(ans, Matchers.is(1L));
    }

    @Test
    void countVowels3() {
        long ans = new Item2063().countVowels("aba");
        MatcherAssert.assertThat(ans, Matchers.is(6L));
    }

    @Test
    void countVowels1() {
        long ans = new Item2063().countVowels("noosabasboosa");
        MatcherAssert.assertThat(ans, Matchers.is(237L));
    }

    @Test
    void countVowels2() {
        long ans = new Item2063().countVowels("abc");
        MatcherAssert.assertThat(ans, Matchers.is(3L));
    }
}