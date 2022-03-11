package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Item401Test {

    @Test
    void readBinaryWatch() {
        List<String> rs = new Item401().readBinaryWatch(1);
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")));
    }

    @Test
    void readBinaryWatch2() {
        List<String> rs = new Item401().readBinaryWatch(2);
        ArrayList<String> a = new ArrayList<>(Arrays.asList("0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"));
        a.sort(String::compareTo);
        MatcherAssert.assertThat(rs, Matchers.is(a));
    }

    @Test
    void readBinaryWatch1() {
        List<String> rs = new Item401().readBinaryWatch(9);
        MatcherAssert.assertThat(rs, Matchers.is(Collections.EMPTY_LIST));
    }
}