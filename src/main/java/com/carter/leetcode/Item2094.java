package com.carter.leetcode;

import java.util.*;

public class Item2094 {
    public int[] findEvenNumbers(int[] digits) {
        int[] ds = new int[10];
        List<Integer> list = new ArrayList<>(900);
        for (int d : digits) {
            ds[d]++;
        }
        for (int i = 100; i <= 999; i++) {
            int[] is = new int[10];
            int temp = i;
            boolean f = true;
            while (temp > 0) {
                int s = temp % 10;
                is[s]++;
                if (is[s] > ds[s]) {
                    f = false;
                    break;
                }
                temp /= 10;
            }
            if (f && (i & 1) == 0) {
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int num : list) {
            ans[i] = num;
            i++;
        }
        return ans;
    }

    public int[] findEvenNumbers2(int[] digits) {
        Set<Integer> set = new HashSet<>(900);
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && (num & 1) == 0) {
                        set.add(num);
                    }
                }
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num : set) {
            ans[i] = num;
            i++;
        }
        Arrays.sort(ans);
        return ans;
    }

    public int[] findEvenNumbers1(int[] digits) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        helper(list, digits, seen, 0, 0, 0);
        int[] ans = new int[list.size()];
        int i = 0;
        for (int num : list) {
            ans[i] = num;
            i++;
        }
        Arrays.sort(ans);
        return ans;
    }

    private void helper(Set<Integer> ans, int[] digits, Set<Integer> seen, int cnt, int d, int num) {
        if (d == 3) {
            if ((num & 1) == 0) {
                ans.add(num);
            }
            return;
        }
        if (cnt == digits.length) {
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            int dd = digits[i];
            if (d == 0 && dd == 0) {
                continue;
            }
            if (seen.contains(i)) {
                continue;
            }
            seen.add(i);
            helper(ans, digits, seen, cnt + 1, d + 1, num * 10 + dd);
            seen.remove(i);
        }
    }
}
