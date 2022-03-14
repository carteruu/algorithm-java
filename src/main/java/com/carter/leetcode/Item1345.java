package com.carter.leetcode;

import java.util.*;

public class Item1345 {
    int INF = 0x3f3f3f3f;

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 倒序插入 list，相当于给 deque 增加一个同层「下标越大，优先出队」的作用
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        dist[0] = 0;
        while (!d.isEmpty()) {
            int t = d.pollFirst(), step = dist[t];
            if (t == n - 1) {
                return step;
            }
            if (t + 1 < n && dist[t + 1] == INF) {
                d.addLast(t + 1);
                dist[t + 1] = step + 1;
            }
            if (t - 1 >= 0 && dist[t - 1] == INF) {
                d.addLast(t - 1);
                dist[t - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == INF) {
                    d.addLast(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[t]);
        }
        return -1; // never
    }

    public int minJumps1(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        boolean[] seen = new boolean[arr.length];
        Map<Integer, List<Integer>> valPos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //连续相同数字,只要头尾
            if (i > 0 && i < arr.length - 1 && arr[i - 1] == arr[i] && arr[i] == arr[i + 1]) {
                continue;
            }
            valPos.putIfAbsent(arr[i], new ArrayList<>());
            valPos.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>(40000);
        queue.offer(0);
        seen[0] = true;
        int ans = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                //右边
                int next = poll + 1;
                if (next < arr.length && !seen[next]) {
                    if (next == arr.length - 1) {
                        //找到了
                        return ans + 1;
                    }
                    queue.offer(next);
                    seen[next] = true;
                }
                //左边
                int pre = poll - 1;
                if (pre >= 0 && !seen[pre]) {
                    queue.offer(pre);
                    seen[pre] = true;
                }
                //相同数字的下标,关键就是遍历完一次后,要删除.避免重复遍历,导致超时
                List<Integer> adjList = valPos.remove(arr[poll]);
                if (adjList != null) {
                    for (int adj : adjList) {
                        if (!seen[adj]) {
                            if (adj == arr.length - 1) {
                                //找到了
                                return ans + 1;
                            }
                            queue.offer(adj);
                            seen[adj] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
