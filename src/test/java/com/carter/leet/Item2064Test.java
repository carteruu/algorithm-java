package com.carter.leet;

import com.carter.leet.Item2064;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2064Test {

    @Test
    void minimizedMaximum() {
        int ans = new Item2064().minimizedMaximum(6, new int[]{11, 6});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void minimizedMaximum3() {
        int ans = new Item2064().minimizedMaximum(15, new int[]{16, 24, 18, 26, 18, 28, 11, 8, 22, 26, 21, 23});
        MatcherAssert.assertThat(ans, Matchers.is(24));
    }

    @Test
    void minimizedMaximum2() {
        int ans = new Item2064().minimizedMaximum(7, new int[]{15, 10, 10});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void minimizedMaximum1() {
        int ans = new Item2064().minimizedMaximum(1, new int[]{100000});
        MatcherAssert.assertThat(ans, Matchers.is(100000));
    }
}