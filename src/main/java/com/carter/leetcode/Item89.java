package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << (n - 1));
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
