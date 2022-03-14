package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item785 {
    public boolean isBipartite(int[][] graph) {
        int[] state = new int[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            if (state[i] == 0) {
                q.offer(i);
                int color = 0b11;
                while (q.size() > 0) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        Integer poll = q.poll();
                        if (state[poll] != 0) {
                            if (state[poll] != color) {
                                return false;
                            }
                        } else {
                            state[poll] = color;
                            for (int c : graph[poll]) {
                                q.offer(c);
                            }
                        }
                    }
                    color ^= 1;
                }
            }
        }
        return true;
    }
}
