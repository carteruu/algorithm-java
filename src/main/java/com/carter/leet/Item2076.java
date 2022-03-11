package com.carter.leet;

import com.carter.UnionFind;

public class Item2076 {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind unionFind = new UnionFind(n);
        boolean[] ans = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int[] req = requests[i];
            int root0 = unionFind.find(req[0]);
            int root1 = unionFind.find(req[1]);
            if (root0 == root1) {
                //已经是朋友了
                ans[i] = true;
                continue;
            }
            ans[i] = true;
            for (int[] res : restrictions) {
                int rootRes0 = unionFind.find(res[0]);
                int rootRes1 = unionFind.find(res[1]);
                if ((root0 == rootRes0 && root1 == rootRes1) || (root0 == rootRes1 && root1 == rootRes0)) {
                    ans[i] = false;
                    break;
                }
            }
            if (ans[i]) {
                unionFind.union(root0, root1);
            }
        }
        return ans;
    }
}