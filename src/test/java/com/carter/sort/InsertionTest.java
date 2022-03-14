package com.carter.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


class InsertionTest {
    @Test
    public void sort() {
        int[] arr = {1, 2, 547, 7, 4, 47, 3, 2, 6, 3};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
