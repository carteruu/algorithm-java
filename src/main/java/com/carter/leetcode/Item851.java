package com.carter.leetcode;

import java.util.*;

public class Item851 {
    /**
     * 从富有的人出发,更新相邻的贫穷节点,扩散开来
     *
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] adjs = new List[quiet.length];
        int[] inDeg = new int[quiet.length];
        int[] ans = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            adjs[i] = new ArrayList<>();
            //答案的初始值为节点自身
            ans[i] = i;
        }
        for (int[] r : richer) {
            //从富有指向贫穷
            adjs[r[0]].add(r[1]);
            //入度
            inDeg[r[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>(quiet.length);
        for (int i = 0; i < quiet.length; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int poll = queue.poll();
            for (int next : adjs[poll]) {
                if (quiet[ans[poll]] < quiet[ans[next]]) {
                    ans[next] = ans[poll];
                }
                inDeg[next]--;
                if (inDeg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return ans;
    }

    public int[] loudAndRich2(int[][] richer, int[] quiet) {
        List<Integer>[] adjs = new List[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] r : richer) {
            //从贫穷指向富有
            adjs[r[1]].add(r[0]);
        }
        int[] ans = new int[quiet.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfs(adjs, quiet, i, ans);
        }
        return ans;
    }

    /**
     * 深度优先,计算当前节点答案时,先计算与其相连且更富有的节点答案,然后找到其中最安静的人(包含自身)
     *
     * @param adjs
     * @param quiet
     * @param idx
     * @param ans
     * @return
     */
    private int dfs(List<Integer>[] adjs, int[] quiet, int idx, int[] ans) {
        if (ans[idx] != -1) {
            return ans[idx];
        }
        ans[idx] = idx;
        for (int next : adjs[idx]) {
            int n = dfs(adjs, quiet, next, ans);
            if (quiet[n] < quiet[ans[idx]]) {
                ans[idx] = n;
            }
        }
        return ans[idx];
    }

    public int[] loudAndRich1(int[][] richer, int[] quiet) {
        List<Integer>[] adjs = new List[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] r : richer) {
            adjs[r[1]].add(r[0]);
        }
        int[] ans = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            int quietMin = quiet[i];
            int idx = i;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            boolean[] seen = new boolean[quiet.length];
            while (queue.size() > 0) {
                int poll = queue.poll();
                if (quiet[poll] < quietMin) {
                    quietMin = quiet[poll];
                    idx = poll;
                }
                for (Integer next : adjs[poll]) {
                    if (seen[next]) {
                        continue;
                    }
                    queue.offer(next);
                    seen[next] = true;
                }
            }
            ans[i] = idx;
        }
        return ans;
    }
}
