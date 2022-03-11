package com.carter.leet;

import java.util.*;

public class Item1719 {
    class Solution {
        int N = 510;
        int[] cnts = new int[N], fa = new int[N];
        boolean[][] g = new boolean[N][N];

        public int checkWays(int[][] pairs) {
            int m = pairs.length;
            Set<Integer> set = new HashSet<>();
            for (int[] p : pairs) {
                int a = p[0], b = p[1];
                g[a][b] = g[b][a] = true;
                cnts[a]++;
                cnts[b]++;
                set.add(a);
                set.add(b);
            }
            List<Integer> list = new ArrayList<>(set);
            list.sort((a, b) -> cnts[b] - cnts[a]);
            int n = list.size(), root = list.get(0);
            if (m < n - 1) {
                // 森林
                return 0;
            }
            fa[root] = -1;
            for (int i = 1; i < n; i++) {
                int a = list.get(i);
                boolean ok = false;
                for (int j = i - 1; j >= 0 && !ok; j--) {
                    int b = list.get(j);
                    if (g[a][b]) {
                        fa[a] = b;
                        ok = true;
                    }
                }
                if (!ok) {
                    return 0;
                }
            }
            int c = 0, ans = 1;
            for (int i : set) {
                int j = i;
                while (fa[j] != -1) {
                    if (!g[i][fa[j]]) {
                        return 0;
                    }
                    if (cnts[i] == cnts[fa[j]]) {
                        ans = 2;
                    }
                    c++;
                    j = fa[j];
                }
            }
            return c < m ? 0 : ans;
        }
    }

    class Solution1 {
        public int checkWays(int[][] pairs) {
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            for (int[] p : pairs) {
                adj.putIfAbsent(p[0], new HashSet<>());
                adj.putIfAbsent(p[1], new HashSet<>());
                adj.get(p[0]).add(p[1]);
                adj.get(p[1]).add(p[0]);
            }
            /* 检测是否存在根节点*/
            int root = -1;
            Set<Map.Entry<Integer, Set<Integer>>> entries = adj.entrySet();
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                int node = entry.getKey();
                Set<Integer> neighbours = entry.getValue();
                if (neighbours.size() == adj.size() - 1) {
                    root = node;
                }
            }
            if (root == -1) {
                return 0;
            }

            int res = 1;
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                int node = entry.getKey();
                Set<Integer> neighbours = entry.getValue();
                if (node == root) {
                    continue;
                }
                int currDegree = neighbours.size();
                int parent = -1;
                int parentDegree = Integer.MAX_VALUE;

                /* 根据 degree 的大小找到 node 的父节点 parent */
                for (int neighbour : neighbours) {
                    if (adj.get(neighbour).size() < parentDegree && adj.get(neighbour).size() >= currDegree) {
                        parent = neighbour;
                        parentDegree = adj.get(neighbour).size();
                    }
                }
                if (parent == -1) {
                    return 0;
                }

                /* 检测 neighbours 是否是 adj[parent] 的子集 */
                for (int neighbour : neighbours) {
                    if (neighbour == parent) {
                        continue;
                    }
                    if (!adj.get(parent).contains(neighbour)) {
                        return 0;
                    }
                }
                if (parentDegree == currDegree) {
                    res = 2;
                }
            }
            return res;
        }
    }

}
