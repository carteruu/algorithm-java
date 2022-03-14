package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item2092Test {
    @Test
    void test1() {
        List<Integer> ans = new Item2092().findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(0, 1, 2, 3, 5)));
    }

    @Test
    void test() {
        List<Integer> ans = new Item2092().findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(0, 1, 3)));
    }

    @Test
    void t() {
        boolean a = b1() || b2() || b3();
    }

    private boolean b1() {
        System.out.println(111);
        return false;
    }

    private boolean b2() {
        System.out.println(222);
        return true;
    }

    private boolean b3() {
        System.out.println(333);
        return false;
    }
}