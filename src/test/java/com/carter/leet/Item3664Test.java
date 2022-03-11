package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class Item3664Test {

    @Test
    void strangePrinter() {
        int times = new Item664().strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa");
        MatcherAssert.assertThat(times,is(2));
    }

    @Test
    void strangePrinter1() {
        int times = new Item664().strangePrinter1("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa");
        MatcherAssert.assertThat(times,is(2));
    }
}