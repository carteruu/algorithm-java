package com.carter.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> set1 = new HashMap<>(arr1.length + arr2.length);
        for (String str : arr1) {
            set1.put(str, set1.getOrDefault(str, 0) + 1);
        }
        for (String str : arr2) {
            set1.put(str, set1.getOrDefault(str, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : set1.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
