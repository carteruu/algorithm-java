package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item748Test {
    @Test
    void shortestCompletingWord() {
        String ans = new Item748().shortestCompletingWord("AN87005", new String[]{"participant", "individual", "start", "exist", "above", "already", "easy", "attack", "player", "important"});
        MatcherAssert.assertThat(ans, Matchers.is("important"));
    }

    @Test
    void shortestCompletingWord1() {
        String ans = new Item748().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        MatcherAssert.assertThat(ans, Matchers.is("pest"));
    }
}