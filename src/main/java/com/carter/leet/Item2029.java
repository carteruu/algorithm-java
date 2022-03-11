package com.carter.leet;

public class Item2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int i : stones) {
            cnt[i % 3]++;
        }
        if (cnt[0] % 2 == 0) {
            return cnt[1] != 0 && cnt[2] != 0;
        }
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }

    public boolean stoneGameIX1(int[] stones) {
        int[] cnt = new int[3];
        int sum = 0;
        for (int stone : stones) {
            int s = stone % 3;
            sum += s;
            cnt[s]++;
        }
        return dfs(sum, 0, cnt, 0);
    }

    private boolean dfs(int sum, int r, int[] cnt, int times) {
        if (sum == r) {
            return false;
        }
        if ((times & 1) == 0) {
            //A
            for (int i = 0; i < 3; i++) {
                if (cnt[i] == 0 || (r + i) % 3 == 0) {
                    continue;
                }
                cnt[i]--;
                if (dfs(sum, r + i, cnt, times + 1)) {
                    cnt[i]++;
                    return true;
                }
                cnt[i]++;
            }
            return false;
        } else {
            //B
            for (int i = 0; i < 3; i++) {
                if (cnt[i] == 0 || (r + i) % 3 == 0) {
                    continue;
                }
                cnt[i]--;
                if (!dfs(sum, r + i, cnt, times + 1)) {
                    cnt[i]++;
                    return false;
                }
                cnt[i]++;
            }
            return true;
        }
    }
}
