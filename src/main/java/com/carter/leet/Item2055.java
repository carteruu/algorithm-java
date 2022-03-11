package com.carter.leet;

public class Item2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        //最近的蜡烛下标
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        //初始化，没有蜡烛
        left[0] = -1;
        right[n] = n;
        //盘子前缀和
        int[] preSum = new int[n + 1];
        for (int l = 0, r = n - 1; l < n; l++, r--) {
            preSum[l + 1] = preSum[l] + (s.charAt(l) == '*' ? 1 : 0);

            left[l + 1] = s.charAt(l) == '|' ? l : left[l];
            right[r] = s.charAt(r) == '|' ? r : right[r + 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            //找到查询左下标的右边最近的蜡烛下标
            int l = right[q[0]];
            //找到查询右下标的左边最近的蜡烛下标
            int r = left[q[1] + 1];
            if (l >= r) {
                continue;
            }
            //使用盘子前缀和计算
            ans[i] = preSum[r + 1] - preSum[l];
        }
        return ans;
    }

    /**
     * 我也不知道周赛的时候怎么想的，居然可以
     *
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int n = s.length();
        //蜡烛前缀和
        int[] cnt = new int[n];
        //盘子前缀和
        int[] left = new int[n];
        int[] right = new int[n];
        char[] cs = s.toCharArray();
        if (cs[0] == '|') {
            cnt[0] = 1;
        } else {
            left[0] = -1;
        }
        right[n - 1] = cs[n - 1] == '|' ? 0 : -1;
        for (int i = 1; i < n; i++) {
            if (cs[i] == '|') {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = cnt[i - 1];
                if (left[i - 1] == -1) {
                    left[i] = -1;
                } else {
                    left[i] = left[i - 1] + 1;
                }
            }

            if (cs[n - 1 - i] == '*') {
                if (right[n - i] == -1) {
                    right[n - 1 - i] = -1;
                } else {
                    right[n - 1 - i] = right[n - i] + 1;
                }
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = q[0] + right[q[0]];
            int r = q[1] - left[q[1]];
            if (l < 0 || r >= n || l >= r || cnt[r] - cnt[l] < 1) {
                ans[i] = 0;
                continue;
            }
            ans[i] = r - l - cnt[r] + cnt[l];
        }
        return ans;
    }
}
