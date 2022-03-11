package com.carter.leet;

import java.util.*;

public class Item90 {
    private int[] nums;
    private int n;
    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        this.n = this.nums.length;
        this.ans = new ArrayList<>();
        dfs(0, new ArrayList<>(nums.length), false);
        return this.ans;
    }

    /**
     * @param idx       当前处理的下标
     * @param arr       当前状态
     * @param preChoice 上一个元素是否被选择,用来排除重复子集
     */
    private void dfs(int idx, List<Integer> arr, boolean preChoice) {
        if (idx == this.n) {
            //全部的元素都判断完了
            this.ans.add(arr);
            return;
        }
        //不选择
        dfs(idx + 1, arr, false);
        //选择:当前元素和上一个元素相同时,只有上一个元素选择了,当前元素才能选择;否则会出现重复子集
        if (idx == 0 || preChoice || nums[idx] != nums[idx - 1]) {
            ArrayList<Integer> newArr = new ArrayList<>(arr);
            newArr.add(this.nums[idx]);
            dfs(idx + 1, newArr, true);
        }
    }
}
