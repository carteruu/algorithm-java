package com.carter.js;

import java.util.PriorityQueue;

public class Item2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        PriorityQueue<Character> max = new PriorityQueue<>(26, (o1, o2) -> o2 - o1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cnt[idx] == 0) {
                max.offer(c);
            }
            cnt[idx]++;
        }
        StringBuilder ans = new StringBuilder(s.length());
        int times = 0;
        while (max.size() > 0) {
            if (ans.length() > 0 && max.peek() != ans.charAt(ans.length() - 1)) {
                times = 0;
            }
            Character head = null;
            if (times >= repeatLimit) {
                if (max.size() == 1) {
                    break;
                }
                head = max.poll();
            }
            ans.append(max.peek());
            int idx = max.peek() - 'a';
            cnt[idx]--;
            if (cnt[idx] == 0) {
                max.poll();
            }
            if (head != null) {
                max.offer(head);
                times = 0;
            } else {
                times++;
            }
        }
        return ans.toString();
    }
}
