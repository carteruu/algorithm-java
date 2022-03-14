package com.carter.leetcode;

public class Item372 {
    private int num = 1337;

    public int superPow(int a, int[] b) {
        a %= 1337;
        int now = 0;
        int ans = 1;
        for (int j : b) {
            now = (now * 10 + j) % 1140;
        }
        for (int i = 0; i < now + 1140; ++i) {
            ans = ans * a % 1337;
        }
        return ans;
    }

    public int superPow1(int a, int[] b) {
        return dfs(a % num, b, 0) % num;
    }

    private int dfs(int a, int[] b, int l) {
        if (l == b.length) {
            return 1;
        }
        if ((b[b.length - 1] & 1) == 1) {
            //奇数
            b[b.length - 1]--;
            return (dfs(a, b, l) * a) % num;
        } else {
            //偶数
            for (int i = b.length - 1; i > l; i--) {
                b[i] = b[i - 1] % 2 * 5 + b[i] / 2;
            }
            b[l] /= 2;
            for (; l < b.length; l++) {
                if (b[l] != 0) {
                    break;
                }
            }
            int dfs = dfs(a, b, l) % num;
            return (dfs * dfs) % num;
        }
    }
}