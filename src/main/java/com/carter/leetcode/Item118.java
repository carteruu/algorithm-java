package com.carter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(Collections.singletonList(1));
        if (numRows == 1) {
            return ans;
        }
        List<Integer> pre = Arrays.asList(1, 1);
        ans.add(pre);
        if (numRows == 2) {
            return ans;
        }
        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            ans.add(item);
            item.add(1);
            for (int j = 1; j < i - 1; j++) {
                item.add(pre.get(j - 1) + pre.get(j));
            }
            item.add(1);
            pre = item;
        }
        return ans;
    }
}
