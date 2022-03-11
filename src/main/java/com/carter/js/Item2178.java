package com.carter.js;

import java.util.ArrayList;
import java.util.List;

public class Item2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) {
            return new ArrayList<>();
        }
        long a = 2;
        List<Long> ans = new ArrayList<>();
        while (finalSum > 0) {
            if (finalSum <= a * 2) {
                ans.add(finalSum);
                break;
            }
            ans.add(a);
            finalSum -= a;
            a += 2;
        }
        return ans;
    }
}

