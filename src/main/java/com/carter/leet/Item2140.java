package com.carter.leet;

public class Item2140 {
    /**
     * 正序DP（刷表法）
     *
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            //不解决当前问题,可以更新下一个问题的分数
            f[i + 1] = Math.max(f[i + 1], f[i]);
            //解决当前问题,可以更新跳到的问题或答案(f[n])
            int j = Math.min(i + questions[i][1] + 1, n);
            f[j] = Math.max(f[j], f[i] + questions[i][0]);
        }
        return f[n];
    }

    /**
     * 倒序DP（填表法）
     *
     * @param questions
     * @return
     */
    public long mostPoints3(int[][] questions) {
        //表示解决区间 [i,n-1][i,n−1] 内的问题可以获得的最高分数。
        long[] dp = new long[questions.length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            //若跳过，则有 f[i]=f[i+1];
            //若解决，则有 f[i]=questions[i][0] + f[next].
            int next = i + questions[i][1] + 1;
            dp[i] = Math.max(dp[i + 1], questions[i][0] + (next < questions.length ? dp[next] : 0));
        }
        return dp[0];
    }

    public long mostPoints2(int[][] questions) {
        long dp[] = new long[questions.length + 100001];
        for (int i = questions.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + questions[i][1] + 1]);
        }
        return dp[0];
    }

    private Long[] cache;

    /**
     * 记忆化搜索
     *
     * @param questions
     * @return
     */
    public long mostPoints1(int[][] questions) {
        cache = new Long[questions.length];
        return dfs(questions, 0);
    }

    private long dfs(int[][] questions, int idx) {
        if (idx >= questions.length) {
            return 0;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        long ans = 0;
        for (int i = idx; i < questions.length && i <= idx + questions[idx][1]; i++) {
            ans = Math.max(ans, questions[i][0] + dfs(questions, i + questions[i][1] + 1));
        }
        cache[idx] = ans;
        return ans;
    }
}
