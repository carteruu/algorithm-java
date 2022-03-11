package com.carter.leet;

import com.carter.UnionFind;

public class Item684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (uf.connected(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
            uf.union(edge[0] - 1, edge[1] - 1);
        }
        throw new IllegalStateException();
    }
}
