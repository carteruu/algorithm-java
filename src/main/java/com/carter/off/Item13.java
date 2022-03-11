package com.carter.off;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item13 {
    private int m;
    private int n;
    private int k;
    private boolean[][] visited;

    public int movingCount1(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int is, int js) {
        if (i >= this.m || j >= this.n || visited[i][j] || is + js > this.k) {
            return 0;
        }
        this.visited[i][j] = true;
        return 1 + dfs(i + 1, j, getSum(i + 1, is), js)
                + dfs(i, j + 1, is, getSum(j + 1, js));
    }

    private int getSum(int pos, int preSum) {
        return pos % 10 == 0 ? preSum - 8 : preSum + 1;
    }

    public int movingCount(int m, int n, int k) {
        int ans = 0;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new ArrayDeque<>((int) Math.pow(n * n + m * m, 0.5));
        q.offer(new int[]{0, 0, 0, 0});
        while (q.size() > 0) {
            int[] poll = q.poll();
            int m1 = poll[0];
            if (m1 < 0 || m1 >= m) {
                continue;
            }
            int n1 = poll[1];
            if (n1 < 0 || n1 >= n) {
                continue;
            }
            if (visited[m1][n1]) {
                continue;
            }
            visited[m1][n1] = true;
            if (poll[2] + poll[3] > k) {
                continue;
            }
            ans++;
            q.offer(new int[]{m1 + 1, n1, getSum(m1 + 1, poll[2]), poll[3]});
            q.offer(new int[]{m1, n1 + 1, poll[2], getSum(n1 + 1, poll[3])});
        }
        return ans;
    }
}
