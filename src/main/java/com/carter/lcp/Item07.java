package com.carter.lcp;

import java.util.*;

public class Item07 {

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] rel : relation) {
                dp[i][rel[1]] += dp[i - 1][rel[0]];
            }
        }
        return dp[k][n - 1];
    }

    public int numWays3(int n, int[][] relation, int k) {
        boolean[][] map = new boolean[n][n];
        for (int[] rel : relation) {
            map[rel[0]][rel[1]] = true;
        }

        int[] timesMap = new int[n];
        int[] tempMap;
        timesMap[0] = 1;

        for (int i = 0; i < k; i++) {
            tempMap = new int[n];
            for (int j = 0; j < n; j++) {
                if (timesMap[j] > 0) {
                    boolean[] booleans = map[j];
                    for (int l = 0; l < n; l++) {
                        if (booleans[l]) {
                            tempMap[l] += timesMap[j];
                        }
                    }
                }
            }
            timesMap = tempMap;
        }
        return timesMap[n - 1];
    }

    public int numWays2(int n, int[][] relation, int k) {
        Map<Integer, boolean[]> map = new HashMap<>();
        for (int[] rel : relation) {
            map.putIfAbsent(rel[0], new boolean[n]);
            map.get(rel[0])[rel[1]] = true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        for (int i = 0; i < k; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                boolean[] next = map.get(poll);
                if (next != null) {
                    for (int l = 0; l < n; l++) {
                        if (next[l]) {
                            queue.add(l);
                        }
                    }
                }
            }
        }
        int rs = 0;
        int target = n - 1;
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            if (poll == target) {
                rs++;
            }
        }
        return rs;
    }

    private int rs = 0;

    public int numWays1(int n, int[][] relation, int k) {
        Map<Integer, boolean[]> map = new HashMap<>();
        for (int[] rel : relation) {
            map.putIfAbsent(rel[0], new boolean[n]);
            map.get(rel[0])[rel[1]] = true;
        }
        way(0, map, k);
        return rs;
    }

    private void way(int idx, Map<Integer, boolean[]> map, int time) {
        if (time <= 0) {
            return;
        }
        time--;
        boolean[] booleans = map.get(idx);
        if (booleans == null) {
            return;
        }
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                if (i == booleans.length - 1 && time == 0) {
                    rs++;
                    continue;
                }
                way(i, map, time);
            }
        }
    }
}
