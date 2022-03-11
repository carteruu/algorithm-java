package com.carter.leet;

import java.util.*;

public class Item743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delayTimes = new int[n + 1];
        Arrays.fill(delayTimes, Integer.MAX_VALUE);
        List<int[]>[] adjs = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            adjs[t[0]].add(t);
        }
        dfs(adjs, delayTimes, k, 0);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, delayTimes[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(List<int[]>[] adjs, int[] delayTimes, int idx, int time) {
        if (time >= delayTimes[idx]) {
            return;
        }
        delayTimes[idx] = time;
        for (int[] adj : adjs[idx]) {
            dfs(adjs, delayTimes, adj[1], time + adj[2]);
        }
    }

    public int networkDelayTime1(int[][] times, int n, int k) {
        List<int[]>[] adjs = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            adjs[t[0]].add(t);
        }
        int[] delayTimes = new int[n + 1];
        Arrays.fill(delayTimes, Integer.MAX_VALUE);
        delayTimes[k] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        while (queue.size() > 0) {
            int poll = queue.poll();
            for (int[] next : adjs[poll]) {
                int delayTime = delayTimes[poll] + next[2];
                if (delayTimes[next[1]] <= delayTime) {
                    continue;
                }
                delayTimes[next[1]] = delayTime;
                queue.offer(next[1]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (delayTimes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, delayTimes[i]);
        }
        return ans;
    }
}
