package com.carter.leetcode;

import java.util.*;

public class Item2065 {
    private int ans = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        //邻接表:当前节点->[[下一个节点,耗时]]
        List<int[]>[] adjs = new List[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjs[edge[0]].add(new int[]{edge[1], edge[2]});
            adjs[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        Map<Integer, Integer> seen = new HashMap<>(n);
        //回溯
        helper(values, maxTime, adjs, seen, 0, 0);
        return ans;
    }

    /**
     * @param values     节点价值
     * @param remainTime 剩余时间
     * @param adjs       邻接表
     * @param seen       节点已被访问次数,为0或空时,才需要增加价值
     * @param curr       当前访问的节点
     * @param val        累计的价值
     */
    private void helper(int[] values, int remainTime, List<int[]>[] adjs, Map<Integer, Integer> seen, int curr, int val) {
        //当前节点未被访问是,增加累计价值
        if (seen.getOrDefault(curr, 0) == 0) {
            val += values[curr];
        }
        //当前节点访问次数+1
        seen.put(curr, seen.getOrDefault(curr, 0) + 1);
        //遍历当前节点的相邻节点,因为可以走回头路,且有时间限制,所以这里不需要任何限制
        for (int i = 0; i < adjs[curr].size(); i++) {
            int[] next = adjs[curr].get(i);
            if (remainTime >= next[1]) {
                //剩余时间 > 到达下一个节点的时间
                helper(values, remainTime - next[1], adjs, seen, next[0], val);
            }
        }
        if (curr == 0) {
            //当回到0节点时,更新最大价值
            this.ans = Math.max(this.ans, val);
        }
        //回溯,当前节点访问次数-1
        seen.put(curr, seen.get(curr) - 1);
    }

    /**
     * TODO 有环的时候,有问题
     *
     * @param values
     * @param edges
     * @param maxTime
     * @return
     */
    public int maximalPathQuality1(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] adjs = new List[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjs[edge[0]].add(new int[]{edge[1], edge[2]});
            adjs[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        return values[0] + m(values, maxTime, adjs, adjs[0]);
    }

    private int m(int[] values, int maxTime, List<int[]>[] children, List<int[]> next) {
        int max = 0;
        for (int i = 0; i < next.size(); i++) {
            int[] n = next.get(i);
            if (maxTime >= 2 * n[1]) {
                List<int[]> nn = new ArrayList<>(next);
                nn.remove(i);
                nn.addAll(children[n[0]]);
                max = Math.max(max, values[n[0]] + m(values, maxTime - 2 * n[1], children, nn));
            }
        }
        return max;
    }
}
