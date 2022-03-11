package com.carter.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item2150 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (cnt.get(num) == 1 && !cnt.containsKey(num - 1) && !cnt.containsKey(num + 1)) {
                ans.add(num);
            }
        }
        return ans;
    }
}
