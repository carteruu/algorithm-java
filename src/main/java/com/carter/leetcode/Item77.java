package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item77 {
    private List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        int l1 = 1;
        int l2 = 1;
        for (int i = 0; i < k; i++) {
            l1 *= n - i;
            l2 *= i + 1;
        }
        ans = new ArrayList<>(l1 / l2);
        dfs(k, n, new ArrayList<>(k));
        return ans;
    }

    private void dfs(int k, int num, List<Integer> path) {
        int size = path.size();
        if (size == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (num == 0) {
            return;
        }
//        if (num + size < k) {
//            return;
//        }
        path.add(num);
        dfs(k, num - 1, path);
        path.remove(size);

        dfs(k, num - 1, path);
    }
}
