package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1190Test {

    @Test
    void reverseParentheses1() {
        String s = new Item1190().reverseParentheses("(abcd)");
        MatcherAssert.assertThat(s, Matchers.is("dcba"));
    }

    @Test
    void reverseParentheses2() {
        String s = new Item1190().reverseParentheses("(u(love)i)");
        MatcherAssert.assertThat(s, Matchers.is("iloveu"));
    }

    @Test
    void reverseParentheses3() {
        String s = new Item1190().reverseParentheses("(ed(et(oc))el)");
        MatcherAssert.assertThat(s, Matchers.is("leetcode"));
    }

    @Test
    void reverseParentheses4() {
        String s = new Item1190().reverseParentheses("a(bcdefghijkl(mno)p)q");
        MatcherAssert.assertThat(s, Matchers.is("apmnolkjihgfedcbq"));
    }

}