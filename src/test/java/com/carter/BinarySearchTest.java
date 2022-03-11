package com.carter;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void find() {
        int rs = new BinarySearch().find(new int[]{1, 2, 3, 4}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }

    @Test
    void find4() {
        int rs = new BinarySearch().find(new int[]{1}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void find3() {
        int rs = new BinarySearch().find(new int[]{1, 2, 3, 4}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void find2() {
        int rs = new BinarySearch().find(new int[]{1, 2, 3, 4}, 0);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void find1() {
        int rs = new BinarySearch().find(new int[]{1, 2, 4}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }


    @Test
    void findLeft() {
        int rs = new BinarySearch().findLeft(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 2);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void findLeft1() {
        int rs = new BinarySearch().findLeft(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void findLeft2() {
        int rs = new BinarySearch().findLeft(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 0);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void findLeft3() {
        int rs = new BinarySearch().findLeft(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }


    @Test
    void findRight() {
        int rs = new BinarySearch().findRight(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 2);
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }

    @Test
    void findRight1() {
        int rs = new BinarySearch().findRight(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void findRight2() {
        int rs = new BinarySearch().findRight(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 0);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void findRight3() {
        int rs = new BinarySearch().findRight(new int[]{1, 2, 2, 2, 2, 2, 3, 4}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }


    @Test
    void minBig() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().minBig(arr, 11);
        MatcherAssert.assertThat(rs, Matchers.is(arr.length));
    }

    @Test
    void minBig2() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().minBig(arr, 1);
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void minBig1() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().minBig(arr, 0);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }


    @Test
    void maxLittle() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().maxLittle(arr, 11);
        MatcherAssert.assertThat(rs, Matchers.is(arr.length - 1));
    }

    @Test
    void maxLittle2() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().maxLittle(arr, 2);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }

    @Test
    void maxLittle1() {
        int[] arr = {1, 2, 3, 4};
        int rs = new BinarySearch().maxLittle(arr, 0);
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }
}