package com.carter.leetcode;

import com.carter.UnionFind;

import java.util.*;

public class Item815_5 {
    /**
     * TODO 超时
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //每个站点的路线
        Map<Integer, List<Integer>> site2LineMap = new HashMap<>();
        int minSite = routes[0][0];
        int maxSite = routes[0][0];
        for (int i = 0; i < routes.length; i++) {
            for (int site : routes[i]) {
                if (site < minSite) {
                    minSite = site;
                }
                if (site > maxSite) {
                    maxSite = site;
                }
                List<Integer> lines = site2LineMap.computeIfAbsent(site, k -> new ArrayList<>());
                lines.add(i);
            }
        }
        int[] dp = new int[maxSite - minSite + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[source - minSite] = 0;
        Queue<Integer> queue = new ArrayDeque<>(site2LineMap.getOrDefault(source, new ArrayList<>()));
        Set<Integer> queueSet = new HashSet<>(queue);
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            queueSet.remove(poll);
            int num = Integer.MAX_VALUE;
            for (int site : routes[poll]) {
                num = Math.min(num, dp[site - minSite]);
            }
            num++;
            for (int site : routes[poll]) {
                if (dp[site - minSite] > num) {
                    dp[site - minSite] = num;
                    for (int line : site2LineMap.getOrDefault(site, new ArrayList<>())) {
                        if (queueSet.contains(line)) {
                            continue;
                        }
                        queue.offer(line);
                    }
                }
            }
        }
        return dp[target - minSite] == Integer.MAX_VALUE ? -1 : dp[target - minSite];
    }

    public int numBusesToDestination3(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        UnionFind uf = new UnionFind((int) 1e6);
        //每个站点的路线
        Map<Integer, List<Integer>> site2LineMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int site : routes[i]) {
                uf.union(site, routes[i][0]);
                List<Integer> lines = site2LineMap.computeIfAbsent(site, k -> new ArrayList<>());
                lines.add(i);
            }
        }
        if (!uf.connected(source, target)) {
            return -1;
        }
        //每个路线到其他路线的邻接表
        List<Integer>[] line2lineAdj = new List[routes.length];
        //遍历每一条路线
        for (int i = 0; i < routes.length; i++) {
            line2lineAdj[i] = new ArrayList<>();
            //遍历该路线的所有站点
            for (int site : routes[i]) {
                //遍历当前站点的所有路线
                for (int l : site2LineMap.getOrDefault(site, new ArrayList<>())) {
                    //更新邻接表
                    line2lineAdj[i].add(l);
                }
            }
        }
        //双向BFS
        //将source站点的路线加入开始队列
        Queue<Integer> queueSrc = new ArrayDeque<>();
        Map<Integer, Integer> numSrc = new HashMap<>();
        for (int line : site2LineMap.getOrDefault(source, new ArrayList<>())) {
            queueSrc.offer(line);
            //开始不在公交车上,需要上车,所以是1
            numSrc.put(line, 1);
        }
        //将target站点的路线加入队列
        Queue<Integer> queueTgt = new ArrayDeque<>();
        Map<Integer, Integer> numTgt = new HashMap<>();
        for (int line : site2LineMap.getOrDefault(target, new ArrayList<>())) {
            queueTgt.offer(line);
            numTgt.put(line, 0);
        }

        while (queueSrc.size() > 0 && queueTgt.size() > 0) {
            int ans;
            if (queueSrc.size() <= queueTgt.size()) {
                ans = bfs(line2lineAdj, queueSrc, numSrc, numTgt);
            } else {
                ans = bfs(line2lineAdj, queueTgt, numTgt, numSrc);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    /**
     * 使用站点双向BFS
     * TODO 超时
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //邻接表
        Set<Integer>[] adjs = new Set[1000000];
        UnionFind uf = new UnionFind(1000000);
        for (int[] route : routes) {
            for (int d : route) {
                if (adjs[d] == null) {
                    adjs[d] = new HashSet<>();
                }
                for (int r : route) {
                    adjs[d].add(r);
                    uf.union(d, r);
                }
            }
        }
        //BFS
        Queue<Integer> queueSrc = new ArrayDeque<>();
        queueSrc.add(source);
        Queue<Integer> queueTgt = new ArrayDeque<>();
        queueTgt.add(target);

        Map<Integer, Integer> numSrc = new HashMap<>();
        numSrc.put(source, 0);
        Map<Integer, Integer> numTgt = new HashMap<>();
        numTgt.put(target, 0);

        while (queueSrc.size() > 0 && queueTgt.size() > 0) {
            int ans;
            if (queueSrc.size() <= queueTgt.size()) {
                ans = bfs(adjs, queueSrc, numSrc, numTgt);
            } else {
                ans = bfs(adjs, queueTgt, numTgt, numSrc);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    private int bfs(Collection<Integer>[] adjs, Queue<Integer> queue, Map<Integer, Integer> curNum, Map<Integer, Integer> otherNum) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer cur = queue.poll();
            int num = curNum.get(cur);
            if (otherNum.containsKey(cur)) {
                //找到了
                return num + otherNum.get(cur);
            }
            for (Integer line : adjs[cur]) {
                if (curNum.containsKey(line)) {
                    //已访问过
                    continue;
                }
                //入队
                queue.offer(line);
                curNum.put(line, num + 1);
            }
        }
        return -1;
    }

    /**
     * 使用站点BSF
     * TODO 超时
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination1(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //邻接表
        Map<Integer, Set<Integer>> adjs = new HashMap<>(routes.length);
        for (int[] route : routes) {
            List<Integer> rList = new ArrayList<>(route.length);
            for (int r : route) {
                rList.add(r);
            }
            for (int d : route) {
                if (!adjs.containsKey(d)) {
                    adjs.put(d, new HashSet<>());
                }
                adjs.get(d).addAll(rList);
            }
        }
        //
        UnionFind uf = new UnionFind(adjs.size());
        for (Map.Entry<Integer, Set<Integer>> entry : adjs.entrySet()) {
            for (int n : entry.getValue()) {
                uf.union(entry.getKey(), n);
            }
        }
        //BFS
        Set<Integer> seen = new HashSet<>();
        seen.add(source);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        int numBuses = 0;
        while (queue.size() > 0) {
            numBuses++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int next : adjs.getOrDefault(poll, new HashSet<>())) {
                    if (next == target) {
                        return numBuses;
                    }
                    if (seen.contains(next)) {
                        continue;
                    }
                    if (!uf.connected(next, target)) {
                        continue;
                    }
                    queue.offer(next);
                    seen.add(next);
                }
            }
        }
        return -1;
    }
}
