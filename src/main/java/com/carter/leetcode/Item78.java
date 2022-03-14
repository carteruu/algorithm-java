package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item78 {
    private List<List<Integer>> ans;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>(nums.length ^ 2);
        dfs1(0, new ArrayList<>(nums.length));
        return ans;
    }

    private void dfs2(int idx, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        //下一步选择哪个数字
        while (idx < nums.length) {
            path.add(nums[idx]);
            dfs2(++idx, path);
            path.remove(path.size() - 1);
        }
    }

    private void dfs1(int idx, List<Integer> path) {
        if (idx == nums.length) {
            ans.add(path);
            return;
        }
        //选择
        dfs1(idx + 1, path);
        //不选择
        ArrayList<Integer> newPath = new ArrayList<>(path);
        newPath.add(nums[idx]);
        dfs1(idx + 1, newPath);
    }
}
