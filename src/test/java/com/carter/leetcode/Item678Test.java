package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item678Test {

    @Test
    void checkValidString() {
        boolean ans = new Item678().checkValidString("()");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void checkValidString7() {
        boolean ans = new Item678().checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void checkValidString6() {
        boolean ans = new Item678().checkValidString("(*()))*(");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void checkValidString5() {
        boolean ans = new Item678().checkValidString("((*)*)*)((*");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void checkValidString4() {
        boolean ans = new Item678().checkValidString("*))");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void checkValidString3() {
        boolean ans = new Item678().checkValidString("");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void checkValidString2() {
        boolean ans = new Item678().checkValidString("((*))");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void checkValidString1() {
        boolean ans = new Item678().checkValidString("((*)))");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }
}