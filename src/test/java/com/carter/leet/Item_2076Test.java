package com.carter.leet;

import com.carter.UnionFind;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item_2076Test {

    @Test
    void friendRequests() {
        boolean[] ans = new Item2076().friendRequests(3,
                new int[][]{{0, 1}},
                new int[][]{{0, 2}, {2, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(new boolean[]{true, false}));
    }

    @Test
    void friendRequests1() {
        boolean[] ans = new Item2076().friendRequests(5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}},
                new int[][]{{0, 4}, {1, 2}, {3, 1}, {3, 4}});
        MatcherAssert.assertThat(ans, Matchers.is(new boolean[]{true, false, true, false}));
    }

    @Test
    void unionFind() {
        UnionFind unionFind = new UnionFind(10);
        boolean connected = unionFind.connected(8, 7);
        MatcherAssert.assertThat(connected, Matchers.is(false));

        unionFind.union(0, 1);
         connected = unionFind.connected(0, 1);
        MatcherAssert.assertThat(connected, Matchers.is(true));

        unionFind.union(0, 2);
        connected = unionFind.connected(2, 1);
        MatcherAssert.assertThat(connected, Matchers.is(true));

        unionFind.union(9, 8);
        connected = unionFind.connected(9, 8);
        MatcherAssert.assertThat(connected, Matchers.is(true));

        unionFind.union(8, 7);
        connected = unionFind.connected(8, 7);
        MatcherAssert.assertThat(connected, Matchers.is(true));
        connected = unionFind.connected(9, 7);
        MatcherAssert.assertThat(connected, Matchers.is(true));

        connected = unionFind.connected(6, 5);
        MatcherAssert.assertThat(connected, Matchers.is(false));
    }
}

