package com.carter.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSort {
    public static void main(String... args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1, 8, 0, 8};
        quickSortNotRecursion(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static void quickSortNotRecursion(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> rootMap = new HashMap<>();
        rootMap.put("startIndex", startIndex);
        rootMap.put("endIndex", endIndex);
        stack.push(rootMap);
        while (!stack.isEmpty()) {
            Map<String, Integer> param = stack.pop();
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                stack.push(leftParam);
            }
            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                if (i == mark) {
                    continue;
                }
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    private static int partitionDouble(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
