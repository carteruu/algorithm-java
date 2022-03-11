package com.carter.leet;

public class Item997 {
    public int findJudge(int n, int[][] trust) {
        //被信任次数
        int[] t = new int[n];
        //信任的人数
        int[] s = new int[n];
        for (int[] tr : trust) {
            t[tr[1] - 1]++;
            s[tr[0] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (t[i] == n - 1 && s[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
