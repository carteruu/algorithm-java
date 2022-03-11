package com.carter.leet;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class Item1787Test {
    @Test
    void minChanges() {
        int count = new Item1787().minChanges(new int[]{1, 2, 0, 3, 0}, 1);
        assertThat(count, is(3));
    }

    @Test
    void minChanges1() {
        int count = new Item1787().minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3);
        assertThat(count, is(3));
    }

    @Test
    void minChanges2() {
        int count = new Item1787().minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3);
        assertThat(count, is(3));
    }

    @Test
    void minChanges3() {
        int count = new Item1787().minChanges(new int[]{26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11}, 3);
        assertThat(count, is(11));
    }
}