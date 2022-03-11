package com.carter.leet;

import com.carter.leet.Item2056;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2056Test {
    @Test
    void countCombinations() {
        int ans = new Item2056().countCombinations(new String[]{"rook"}, new int[][]{{1, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }

    @Test
    void countCombinations9() {
        int ans = new Item2056().countCombinations(new String[]{"rook", "rook"}, new int[][]{{1, 1}, {2, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(196));
    }

    @Test
    void countCombinations8() {
        int ans = new Item2056().countCombinations(new String[]{"bishop", "queen"}, new int[][]{{8, 5}, {7, 7}});
        MatcherAssert.assertThat(ans, Matchers.is(168));
    }

    @Test
    void countCombinations7() {
        int ans = new Item2056().countCombinations(new String[]{"rook"}, new int[][]{{7, 7}});
        MatcherAssert.assertThat(ans, Matchers.is(15));
    }

    @Test
    void countCombinations6() {
        int ans = new Item2056().countCombinations(new String[]{"bishop"}, new int[][]{{8, 5}});
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void countCombinations5() {
        int ans = new Item2056().countCombinations(new String[]{"bishop", "rook"}, new int[][]{{8, 5}, {7, 7}});
        MatcherAssert.assertThat(ans, Matchers.is(96));
    }

    @Test
    void countCombinations3() {
        int ans = new Item2056().countCombinations(new String[]{"rook", "rook"}, new int[][]{{1, 1}, {8, 8}});
        MatcherAssert.assertThat(ans, Matchers.is(223));
    }

    @Test
    void countCombinations2() {
        int ans = new Item2056().countCombinations(new String[]{"queen", "bishop"}, new int[][]{{5, 7}, {3, 4}});
        MatcherAssert.assertThat(ans, Matchers.is(281));
    }

    @Test
    void countCombinations1() {
        int ans = new Item2056().countCombinations(new String[]{"queen"}, new int[][]{{1, 1}});
        MatcherAssert.assertThat(ans, Matchers.is(22));
    }

    @Test
    void countCombinations4() {
        int ans = new Item2056().countCombinations(new String[]{"bishop"}, new int[][]{{4, 3}});
        MatcherAssert.assertThat(ans, Matchers.is(12));
    }
}