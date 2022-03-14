package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class item2156Test {

    @Test
    void test() {
        String ans = new item2156().subStrHash("leetcode", 7, 20, 2, 0);
        MatcherAssert.assertThat(ans, Matchers.is("ee"));
    }

    @Test
    void test3() {
        String ans = new item2156().subStrHash("xxterzixjqrghqyeketqeynekvqhc"
                , 15
                , 94
                , 4
                , 16);
        MatcherAssert.assertThat(ans, Matchers.is("nekv"));
    }

    @Test
    void test1() {
        String ans = new item2156().subStrHash("fbxzaad", 31, 100, 3, 32);
        MatcherAssert.assertThat(ans, Matchers.is("fbx"));
    }

    @Test
    void test2() {
        String ans = new item2156().subStrHash("xmmhdakfursinye"
                , 96
                , 45
                , 15
                , 21);
        MatcherAssert.assertThat(ans, Matchers.is("xmmhdakfursinye"));
    }
}