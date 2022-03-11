package com.carter.leet;

public class Item990 {
    public boolean equationsPossible(String[] equations) {
        FindUnion fu = new FindUnion(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                fu.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!' && fu.isConnected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    private static class FindUnion {
        private int[] parents;

        public FindUnion(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
            }
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            parents[rootA] = rootB;
            return true;
        }

        private int find(int node) {
            while (parents[node] != parents[parents[node]]) {
                //父节点的父节点,不是它自身的话(父节点不是根),将节点移到祖父节点下(上移一层),降低树的高度
                parents[node] = parents[parents[node]];
            }
            return parents[node];
        }
    }
}
