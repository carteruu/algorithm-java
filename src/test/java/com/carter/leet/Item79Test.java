package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Item79Test {
    @Test
    void exist() {
        boolean ans = new Item79().exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "bacd");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void exist4() {
        boolean ans = new Item79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void exist3() {
        boolean ans = new Item79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void exist2() {
        boolean ans = new Item79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void exist1() {
        boolean ans = new Item79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}