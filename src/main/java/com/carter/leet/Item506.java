package com.carter.leet;

import java.util.*;

public class Item506 {
    public String[] findRelativeRanks(int[] score) {
        int max = score[0];
        int min = score[0];
        for (int s : score) {
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
        }
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < score.length; i++) {
            arr[score[i] - min] = i + 1;
        }
        String[] ans = new String[score.length];
        int m = 1;
        for (int i = max - min; i >= 0; i--) {
            if (arr[i] > 0) {
                switch (m) {
                    case 1: {
                        ans[arr[i] - 1] = "Gold Medal";
                        break;
                    }
                    case 2: {
                        ans[arr[i] - 1] = "Silver Medal";
                        break;
                    }
                    case 3: {
                        ans[arr[i] - 1] = "Bronze Medal";
                        break;
                    }
                    default: {
                        ans[arr[i] - 1] = String.valueOf(m);
                    }
                }
                m++;
            }
        }
        return ans;
    }

    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        Map<Integer, String> ms = new HashMap<>();
        ms.put(1, "Gold Medal");
        ms.put(2, "Silver Medal");
        ms.put(3, "Bronze Medal");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(score.length, (o1, o2) -> Integer.compare(score[o2], score[o1]));
        for (int i = 0; i < score.length; i++) {
            maxHeap.offer(i);
        }
        int m = 1;
        while (maxHeap.size() > 0) {
            ans[maxHeap.poll()] = ms.getOrDefault(m, String.valueOf(m));
            m++;
        }
        return ans;
    }

    public String[] findRelativeRanks3(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(score.length, (o1, o2) -> Integer.compare(score[o2], score[o1]));
        for (int i = 0; i < score.length; i++) {
            maxHeap.offer(i);
        }
        if (maxHeap.size() > 0) {
            ans[maxHeap.poll()] = "Gold Medal";
        }
        if (maxHeap.size() > 0) {
            ans[maxHeap.poll()] = "Silver Medal";
        }
        if (maxHeap.size() > 0) {
            ans[maxHeap.poll()] = "Bronze Medal";
        }
        int m = 4;
        while (maxHeap.size() > 0) {
            ans[maxHeap.poll()] = String.valueOf(m);
            m++;
        }
        return ans;
    }

    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, Comparator.comparing(o -> score[o]));
        ans[idxs[n - 1]] = "Gold Medal";
        if (n >= 2) {
            ans[idxs[n - 2]] = "Silver Medal";
            if (n >= 3) {
                ans[idxs[n - 3]] = "Bronze Medal";
            }
        }
        for (int i = n - 3; i >= 0; i--) {
            ans[idxs[i]] = String.valueOf(n - i);
        }
        return ans;
    }
}
