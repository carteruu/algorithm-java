package com.carter.leet;

import com.carter.leet.Item2062;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2062Test {

    @Test
    void countVowelSubstrings() {
        int ans = new Item2062().countVowelSubstrings("aeiouu");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void countVowelSubstrings2() {
        int ans = new Item2062().countVowelSubstrings("unicornarihan");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void countVowelSubstrings1() {
        int ans = new Item2062().countVowelSubstrings("cuaieuouac");
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }
}