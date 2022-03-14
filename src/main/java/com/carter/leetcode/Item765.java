package com.carter.leetcode;

public class Item765 {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] cache = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            cache[row[i]] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            int a = row[i];
            int b = a ^ 1;
            if (row[i + 1] != b) {
                int bIdx = cache[b];

                int t = row[i + 1];
                row[i + 1] = b;
                row[bIdx] = t;

                cache[t] = bIdx;
                cache[b] = i + 1;
                ans++;
            }
        }
        return ans;
    }

    public int minSwapsCouples2(int[] row) {
        UnionFind uf = new UnionFind(row.length / 2);
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return row.length / 2 - uf.cnt;
    }

    private static class UnionFind {
        private final int[] parents;
        private int cnt;

        public UnionFind(int n) {
            this.cnt = n;
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            parents[rootA] = rootB;
            this.cnt--;
            return true;
        }

        private int find(int node) {
            while (parents[node] != parents[parents[node]]) {
                parents[node] = parents[parents[node]];
            }
            return parents[node];
        }
    }

    public int minSwapsCouples1(int[] row) {
        return swap(row, 0);
    }

    private int swap(int[] row, int a) {
        if (a >= row.length) {
            return 0;
        }
        int b = a + 1;
        int step = Integer.MAX_VALUE / 2;
        if (Math.abs(row[a] - row[b]) == 1) {
            step = swap(row, a + 2);
        }
        for (int i = b + 1; i < row.length; i++) {
            if (Math.abs(row[i] - row[b]) == 1) {
                //交换a
                int temp = row[a];
                row[a] = row[i];
                row[i] = temp;
                step = Math.min(step, swap(row, a + 2) + 1);
                //还原
                row[i] = row[a];
                row[a] = temp;
            }
            if (Math.abs(row[i] - row[a]) == 1) {
                //交换b
                int temp = row[b];
                row[b] = row[i];
                row[i] = temp;
                step = Math.min(step, swap(row, a + 2) + 1);
                //还原
                row[i] = row[b];
                row[b] = temp;
            }
        }
        return step;
    }
}
