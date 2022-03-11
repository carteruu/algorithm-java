package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item981Test {
    @Test
    void get() {
        Item981.TimeMap timeMap = new Item981.TimeMap();
        String s = timeMap.get("11", 1);
        MatcherAssert.assertThat(s, Matchers.is(""));

        timeMap.set("11", "11", 11);
        String s1 = timeMap.get("11", 10);
        MatcherAssert.assertThat(s1, Matchers.is(""));
        MatcherAssert.assertThat(timeMap.get("11", 11), Matchers.is("11"));
        MatcherAssert.assertThat(timeMap.get("11", 12), Matchers.is("11"));
    }


    @Test
    void get1() {
        Item981.TimeMap timeMap = new Item981.TimeMap();
        timeMap.set("foo", "bar", 1);
        MatcherAssert.assertThat(timeMap.get("foo", 1), Matchers.is("bar"));
        MatcherAssert.assertThat(timeMap.get("foo", 3), Matchers.is("bar"));

        timeMap.set("foo", "bar2", 4);
        MatcherAssert.assertThat(timeMap.get("foo", 4), Matchers.is("bar2"));
        MatcherAssert.assertThat(timeMap.get("foo", 5), Matchers.is("bar2"));
    }
}