package com.carter.sort;

public class Insertion {
    public static void sort(int[] arr) {
        int sortLen = 1;
        for (int i = 1; i < arr.length; i++) {
            int n = i;
            for (int j = sortLen - 1; j >= 0; j--) {
                if (arr[n] < arr[j]) {
                    int tmp = arr[n];
                    arr[n] = arr[j];
                    arr[j] = tmp;

                    n = j;
                }
            }
            sortLen++;
        }
    }
}
