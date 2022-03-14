package com.carter.leetcode;

import java.util.*;

public class Item846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : hand) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (int num : hand) {
            if (!cntMap.containsKey(num)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int curr = num + j;
                Integer cnt = cntMap.get(curr);
                if (cnt == null) {
                    return false;
                }
                if (cnt == 1) {
                    cntMap.remove(curr);
                } else {
                    cntMap.put(curr, cnt - 1);
                }
            }
        }
        return true;
    }

    public boolean isNStraightHand2(int[] hand, int groupSize) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : hand) {
            if (cnt.containsKey(num)) {
                cnt.put(num, cnt.get(num) + 1);
            } else {
                p.offer(num);
                cnt.put(num, 1);
            }
        }
        int[] temp = new int[groupSize];
        while (p.size() >= groupSize) {
            temp[0] = p.poll();
            for (int i = 1; i < groupSize; i++) {
                temp[i] = p.poll();
                if (temp[i] != temp[i - 1] + 1) {
                    return false;
                }
            }
            for (int i = 0; i < groupSize; i++) {
                if (cnt.get(temp[i]) == 1) {
                    cnt.remove(temp[i]);
                } else {
                    cnt.put(temp[i], cnt.get(temp[i] - 1));
                    p.offer(temp[i]);
                }
            }
        }
        return p.size() == 0;
    }

    public boolean isNStraightHand1(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() > 0) {
            int curr = map.firstKey();
            if (map.get(curr) == 1) {
                map.remove(curr);
            } else {
                map.put(curr, map.get(curr) - 1);
            }
            for (int i = 1; i < groupSize; i++) {
                curr++;
                Integer times = map.get(curr);
                if (times == null) {
                    return false;
                }
                if (times == 1) {
                    map.remove(curr);
                } else {
                    map.put(curr, times - 1);
                }
            }
        }
        return true;
    }
}
