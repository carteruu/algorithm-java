package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item794Test {

    @Test
    void validTicTacToe() {
        boolean ans = new Item794().validTicTacToe(new String[]{"XXO", "XOX", "OXO"});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void validTicTacToe3() {
        boolean ans = new Item794().validTicTacToe(new String[]{"XOX", "O O", "XOX"});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void validTicTacToe2() {
        boolean ans = new Item794().validTicTacToe(new String[]{"XXX", "OOX", "OOX"});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void validTicTacToe1() {
        String[] board = {"XXX", "XOO", "OO "};
        boolean ans = new Item794().validTicTacToe(board);
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}