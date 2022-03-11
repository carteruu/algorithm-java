package com.carter.leet;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Item1049 {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        int sum = Arrays.stream(stones).sum();
        boolean[] arr = new boolean[sum / 2];
        arr[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int j = arr.length - 1; j >= stones[i]; j--) {
                arr[j] = arr[j - stones[i]] || arr[j];
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    public int lastStoneWeightII1(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            heap.add(stone);
        }
        int l;
        int big;
        while (heap.size() > 0) {
            big = heap.poll();
            if (heap.isEmpty()) {
                return big;
            }
            l = big - heap.poll();
            if (l > 0) {
                heap.add(l);
            }
        }
        return 0;
    }
}
