package com.carter.leetcode;

import java.util.*;

public class Item802 {
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        int[] outDeg = new int[graph.length];
        List<Integer>[] adjs = new List[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            adjs[i] = new ArrayList<>();
            outDeg[i] = graph[i].length;
            if (outDeg[i] == 0) {
                queue.offer(i);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int g : graph[i]) {
                adjs[g].add(i);
            }
        }
        while (queue.size() > 0) {
            int poll = queue.poll();
            for (int pre : adjs[poll]) {
                outDeg[pre]--;
                if (outDeg[pre] == 0) {
                    queue.offer(pre);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (outDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] color = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int[][] graph, int[] color, int idx) {
        if (color[idx] > 0) {
            return color[idx] == 2;
        }
        color[idx] = 1;
        for (int next : graph[idx]) {
            if (!dfs(graph, color, next)) {
                return false;
            }
        }
        color[idx] = 2;
        return true;
    }
}
