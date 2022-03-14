package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item33Test {
    @Test
    void search() {
        int rs = new Item33().search(new int[]{1}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void search2() {
        int rs = new Item33().search(new int[]{3, 1}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void search1() {
        int rs = new Item33().search(new int[]{1, 3}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void find() {
        int rs = new Item33().find(new int[]{1}, 0, 0, 1);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }
}
