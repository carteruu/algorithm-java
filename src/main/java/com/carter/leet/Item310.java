package com.carter.leet;

import java.util.*;

public class Item310 {
    //邻接表
    private List<Integer>[] links;
    private int[] degree;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rs = new ArrayList<>();
        if (n == 0) {
            return rs;
        }
        if (n == 1) {
            rs.add(0);
            return rs;
        }
        List<Integer>[] links = new List[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            rs = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                rs.add(node);
                for (int parent : links[node]) {
                    degree[parent]--;
                    if (degree[parent] == 1) {
                        queue.offer(parent);
                    }
                }
            }
        }
        return rs;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        link(n, edges);

        List<Integer> rs = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int height = height(i, new HashSet<>());
            if (height == min) {
                rs.add(i);
            } else if (height < min) {
                min = height;
                rs.clear();
                rs.add(i);
            }
        }
        return rs;
    }

    private void link(int n, int[][] edges) {
        links = new List[n];
        degree = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }
    }

    private int height(int root, Set<Integer> processed) {
        processed.add(root);
        int h = 0;
        for (int child : links[root]) {
            if (!processed.contains(child)) {
                h = Math.max(h, height(child, processed));
            }
        }
        h++;
        return h;
    }
}
