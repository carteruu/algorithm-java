package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, -1, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx + 1; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && idx != i - 1) {
                continue;
            }
            if (target < candidates[i]) {
                return;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
