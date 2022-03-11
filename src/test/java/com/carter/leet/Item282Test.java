package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item282Test {

    @Test
    void addOperators() {
        List<String> rs = new Item282().addOperators("123", 6);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("1+2+3", "1*2*3")));
    }

    @Test
    void addOperators3() {
        List<String> rs = new Item282().addOperators("232", 8);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("2*3+2", "2+3*2")));
    }

    @Test
    void addOperators2() {
        List<String> rs = new Item282().addOperators("105", 5);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("1*0+5", "10-5")));
    }

    @Test
    void addOperators1() {
        List<String> rs = new Item282().addOperators("3456237490", 9191);
        MatcherAssert.assertThat(rs, Matchers.is(new ArrayList<>()));
    }
}