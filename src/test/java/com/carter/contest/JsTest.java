package com.carter.contest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class JsTest {

    @Test
    void test1() {
        int ans = new Js().test();
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}