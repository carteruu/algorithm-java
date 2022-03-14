package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item523Test {

    @Test
    void checkSubarraySum() {
        boolean rs = new Item523().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum7() {
        boolean rs = new Item523().checkSubarraySum(new int[]{0, 0}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum6() {
        boolean rs = new Item523().checkSubarraySum(new int[]{422, 224, 184, 178, 189, 290, 196, 236, 281, 464, 351, 193, 49, 76, 0, 298, 193, 176, 158, 514, 312, 143, 475, 322, 206, 67, 524, 424, 76, 99, 473, 256, 364, 292, 141, 186, 190, 69, 433, 205, 93, 72, 476, 393, 512, 468, 160, 201, 226, 394, 47, 140, 389, 51, 142, 135, 349, 244, 16, 356, 440, 188, 16, 133, 58, 394, 7, 517, 56, 480, 400, 146, 169, 439, 102, 374, 370, 242, 4, 264, 120, 218, 196, 173, 215, 411, 501, 321, 319, 147, 369, 458, 319, 174, 379, 46, 129, 353, 330, 101}, 479);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum5() {
        boolean rs = new Item523().checkSubarraySum(new int[]{1, 2, 12}, 6);
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }

    @Test
    void checkSubarraySum4() {
        boolean rs = new Item523().checkSubarraySum(new int[]{5, 0, 0, 0}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum3() {
        boolean rs = new Item523().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum1() {
        boolean rs = new Item523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6);
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void checkSubarraySum2() {
        boolean rs = new Item523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13);
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }
}