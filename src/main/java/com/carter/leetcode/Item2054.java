package com.carter.leetcode;

import java.util.Arrays;

public class Item2054 {
    public int maxTwoEvents(int[][] events) {
        int[][] es = new int[events.length * 2][3];
        for (int i = 0; i < events.length; i++) {
            es[i * 2] = new int[]{events[i][0], 0, events[i][2]};
            es[i * 2 + 1] = new int[]{events[i][1], 1, events[i][2]};
        }
        Arrays.sort(es, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int ans = 0;
        int bestFirst = 0;
        for (int[] e : es) {
            if (e[1] == 0) {
                ans = Math.max(ans, e[2] + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, e[2]);
            }
        }
        return ans;
    }
}
