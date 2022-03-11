package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item2000Test {

    @Test
    void reversePrefix() {
        String ans = new Item2000().reversePrefix("abcdefd", 'd');
        MatcherAssert.assertThat(ans, Matchers.is("dcbaefd"));
    }

    @Test
    void reversePrefix1() {
        String ans = new Item2000().reversePrefix("abcd", 'z');
        MatcherAssert.assertThat(ans, Matchers.is("abcd"));
    }
}