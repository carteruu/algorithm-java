package com.carter.interview;

import java.util.*;

public class Item1619 {
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        UnionFind uf = new UnionFind(m * n);
        int[][] steps = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    int idx = i * n + j;
                    for (int[] step : steps) {
                        int ni = i + step[0];
                        int nj = j + step[1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && land[ni][nj] == 0) {
                            uf.union(idx, ni * n + nj);
                        }
                    }
                }
            }
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (land[i][j] == 0) {
                    list.add(uf.find(idx));
                }
            }
        }
        int[] ans = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            ans[idx] = uf.sizes[i];
            idx++;
        }
        Arrays.sort(ans);
        return ans;
    }

    private static class UnionFind {
        private final int[] parents;
        private final int[] sizes;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
                this.sizes[i] = 1;
            }
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            sizes[rootB] += sizes[rootA];
            parents[rootA] = rootB;
            return true;
        }

        private int find(int node) {
            while (parents[node] != parents[parents[node]]) {
                sizes[parents[node]] -= sizes[node];
                parents[node] = parents[parents[node]];
            }
            return parents[node];
        }
    }
}


//class Solution {
//    // 四个方向就够了
//    int[][] dirs = new int[][]{
//            {0, 1}, {1, 0}, {1, -1}, {1, 1}
//            // {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
//    };
//    int area = 0;
//
//    public int[] pondSizes(int[][] land) {
//        List<Integer> res = new ArrayList<>();
//        int m = land.length;
//        int n = land[0].length;
//        int nodeCount = m * n;
//        UnionFind uf = new UnionFind(nodeCount);
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                // 从单点水域向八面扩散搜索 同为水域者收入麾下
//                if (land[i][j] == 0) {
//                    for (int[] dir : dirs) {
//                        int x2 = i + dir[0];
//                        int y2 = j + dir[1];
//                        // 发现新水域 收入麾下 野蛮。。。
//                        if(inArea(land, x2, y2) && land[x2][y2] == 0) {
//                            uf.union(i*n+j, x2*n+y2);
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i < uf.parent.length; i++) {
//            // 统计各首领的领"水"面积
//            // 满足两个条件: 1. 各个分支的首领 2. 该首领是水域
//            if(uf.parent[i] == i && land[i/n][i%n] == 0) {
//                res.add(uf.size[i]);
//            }
//        }
//
//        int[] ans = new int[res.size()];
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = res.get(i);
//        }
//
//        Arrays.sort(ans);
//        return ans;
//    }
//
//    boolean inArea(int[][] land, int x, int y) {
//        return x >= 0 && y >= 0 && x < land.length && y < land[0].length;
//    }
//
//    class UnionFind {
//        public int count;
//        public int[] parent;
//        public int[] size;
//
//        public UnionFind(int amount) {
//            this.count = amount;
//            parent = new int[count];
//            size = new int[count];
//            for (int i = 0; i < count; i++) {
//                parent[i] = i;
//            }
//            Arrays.fill(size, 1);
//            // 让所有水域都以此为首
//            // size[count-1] = count;
//        }
//
//        public int find(int x) {
//            while (parent[x] != x) {
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
//            return x;
//        }
//
//        public void union(int p, int q) {
//            int pRoot = find(p);
//            int qRoot = find(q);
//            if (pRoot == qRoot) {
//                return;
//            }
//            // 大树好乘凉
//            if (size[pRoot] > size[qRoot]) {
//                parent[qRoot] = pRoot;
//                size[pRoot] += size[qRoot];
//            } else {
//                parent[pRoot] = qRoot;
//                size[qRoot] += size[pRoot];
//            }
//            count--;
//        }
//    }
//}