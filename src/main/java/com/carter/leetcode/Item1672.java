package com.carter.leetcode;

import java.util.Arrays;

public class Item1672 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(a-> Arrays.stream(a).sum()).max().getAsInt();
    }
}
