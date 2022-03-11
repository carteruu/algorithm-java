package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1436Test {

    @Test
    void checkIfExist() {
        boolean rs = new Item1436().checkIfExist(new int[]{10, 2, 5, 3});
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkIfExist3() {
        boolean rs = new Item1436().checkIfExist(new int[]{1, 1});
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }

    @Test
    void checkIfExist2() {
        boolean rs = new Item1436().checkIfExist(new int[]{-778, -481, 842, 495, 44, 1000, -572, 977, 240, -116, 673, 997, -958, -539, -964, -187, -701, -928, 472, 965, -672, -88, 443, 36, 388, -127, 115, 704, -549, 1000, 998, 291, 633, 423, 57, -77, -543, 72, 328, -938, -192, 382, 179});
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkIfExist1() {
        boolean rs = new Item1436().checkIfExist(new int[]{3, 1, 7, 11});
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }
}