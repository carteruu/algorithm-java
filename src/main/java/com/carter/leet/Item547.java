package com.carter.leet;

import com.carter.UnionFind;

public class Item547 {
    public int findCircleNum(int[][] isConnected) {
        UnionFind un = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    un.union(i, j);
                }
            }
        }
        return un.getCnt();
    }
}
