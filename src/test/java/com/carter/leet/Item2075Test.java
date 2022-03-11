package com.carter.leet;

import com.carter.leet.Item2075;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2075Test {

    @Test
    void decodeCiphertext() {
        String ans = new Item2075().decodeCiphertext("ch   ie   pr", 3);
        MatcherAssert.assertThat(ans, Matchers.is("cipher"));
    }

    @Test
    void decodeCiphertext1() {
        String ans = new Item2075().decodeCiphertext(" b  ac", 2);
        MatcherAssert.assertThat(ans, Matchers.is(" abc"));
    }
}