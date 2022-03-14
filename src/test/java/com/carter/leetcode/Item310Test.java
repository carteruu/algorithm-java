package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item310Test {

    @Test
    void findMinHeightTrees() {
        List<Integer> rs = new Item310().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList(1)));
    }

    @Test
    void findMinHeightTrees1() {
        List<Integer> rs = new Item310().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList(3, 4)));
    }
}