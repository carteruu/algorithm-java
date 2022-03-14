package com.carter.leetcode;

public class Item1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] preCount = new long[candiesCount.length];
        preCount[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            preCount[i] = preCount[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            long count = preCount[query[0]];
            ans[i] = query[1] + 1 <= count && count - candiesCount[query[0]] <  ((long)query[1] + 1) * query[2];
        }
        return ans;
    }
}
