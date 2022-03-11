package com.carter;

import java.util.Arrays;

public class BinaryHeap {
    public static void upAdjust(int[] arr) {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = arr[childIndex];
        while (childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        arr[childIndex] = temp;
    }

    public static void downAdjust(int[] arr, int parentIndex, int length) {
        if (arr == null || parentIndex < 0 || parentIndex > arr.length || length > arr.length) {
            return;
        }
        int childIndex = 2 * parentIndex + 1;
        int temp = arr[parentIndex];
        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            if (temp < arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
    }

    public static void main(String... args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
