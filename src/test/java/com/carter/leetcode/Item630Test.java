package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item630Test {

    @Test
    void scheduleCourse() {
        int ans = new Item630().scheduleCourse(new int[][]{{2, 5}, {2, 19}, {1, 8}, {1, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void scheduleCourse6() {
        int ans = new Item630().scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void scheduleCourse5() {
        int ans = new Item630().scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void scheduleCourse4() {
        int ans = new Item630().scheduleCourse(new int[][]{{5, 11}, {3, 5}, {10, 20}, {4, 20}, {10, 16}});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void scheduleCourse3() {
        int ans = new Item630().scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void scheduleCourse2() {
        int ans = new Item630().scheduleCourse(new int[][]{{1, 2}});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void scheduleCourse1() {
        int ans = new Item630().scheduleCourse(new int[][]{{3, 2}, {4, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }
}