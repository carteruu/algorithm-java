package com.carter.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item39 {
    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 1);
    }

    public int combinationSum3(int[] candidates, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target < 0) {
            return 0;
        }
        int ans = 0;
        for (int c : candidates) {
            ans += combinationSum1(candidates, target - c);
        }
        return ans;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || idx == candidates.length) {
            return;
        }
        helper(candidates, target, idx + 1, path, ans);
        if (target >= candidates[idx]) {
            path.add(candidates[idx]);
            helper(candidates, target - candidates[idx], idx, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());
        for (int i = 1; i <= candidates.length; i++) {
            List<List<Integer>>[] temp = new List[target + 1];
            for (int j = 0; j <= target; j++) {
                temp[j] = new ArrayList<>();
                for (List<Integer> list : dp[j]) {
                    temp[j].add(new ArrayList<>(list));
                }
                if (j >= candidates[i - 1]) {
                    for (List<Integer> list : temp[j - candidates[i - 1]]) {
                        ArrayList<Integer> l = new ArrayList<>(list);
                        l.add(candidates[i - 1]);
                        temp[j].add(l);
                    }
                }
            }
            dp = temp;
        }
        return dp[target];
    }

    public int combinationSum1(int[] candidates, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= candidates.length; i++) {
            int[] temp = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                temp[j] = dp[j];
                if (j >= candidates[i - 1]) {
                    temp[j] += temp[j - candidates[i - 1]];
                }
            }
            dp = temp;
        }
        List<List<Integer>> ans = new ArrayList<>();


        return dp[target];
    }
}
