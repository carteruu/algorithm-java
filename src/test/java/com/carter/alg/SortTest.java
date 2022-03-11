package com.carter.alg;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void bubbleSort() {
        int[] a = {1, 5, 3, 4};
        new Sort().bubbleSort(a, a.length);
        MatcherAssert.assertThat(a, Matchers.is(new int[]{1, 3, 4, 5}));
    }

    @Test
    void insertionSort() {
        int[] a = {1, 5, 3, 4};
        new Sort().insertionSort(a, a.length);
        MatcherAssert.assertThat(a, Matchers.is(new int[]{1, 3, 4, 5}));
    }

    @Test
    void selectionSort() {
        int[] a = {1, 5, 3, 4};
        new Sort().selectionSort(a, a.length);
        MatcherAssert.assertThat(a, Matchers.is(new int[]{1, 3, 4, 5}));
    }

    @Test
    void mergeSort() {
        int[] a = {1, 5, 3, 4};
        new Sort().mergeSort(a, 0, a.length - 1);
        MatcherAssert.assertThat(a, Matchers.is(new int[]{1, 3, 4, 5}));
    }

    @Test
    void quicksort() {
        int[] a = {1, 5, 3, 4};
        new Sort().quicksort(a, 0, a.length - 1);
        MatcherAssert.assertThat(a, Matchers.is(new int[]{1, 3, 4, 5}));
    }
}