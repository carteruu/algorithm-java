package com.carter.off;


import java.util.Arrays;

public class Item40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
}
