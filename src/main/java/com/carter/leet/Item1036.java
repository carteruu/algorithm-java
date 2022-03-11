package com.carter.leet;


import java.util.*;

public class Item1036 {
    private final int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int n = (int) 1e6;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) {
            return true;
        }

        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add((long) b[0] * n + b[1]);
        }
        Queue<int[]> queueSource = new ArrayDeque<>();
        queueSource.offer(source);
        Queue<int[]> queueTarget = new ArrayDeque<>();
        queueTarget.offer(target);

        Set<Long> setSource = new HashSet<>();
        setSource.add((long) source[0] * n + source[1]);

        Set<Long> setTarget = new HashSet<>();
        setTarget.add((long) target[0] * n + target[1]);

        int max = (1 + blocked.length - 1) / 2 * (blocked.length - 1);
        while (queueSource.size() > 0 && queueTarget.size() > 0) {
            if (queueSource.size() < queueTarget.size()) {
                if (this.helper(blockedSet, queueSource, setSource, setTarget)) {
                    return true;
                }
            } else {
                if (this.helper(blockedSet, queueTarget, setTarget, setSource)) {
                    return true;
                }
            }
            if (setSource.size() > max && setTarget.size() > max) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(Set<Long> blockedSet, Queue<int[]> q, Set<Long> setFrom, Set<Long> setTo) {
        int[] poll = q.poll();
        for (int[] step : steps) {
            int x = poll[0] + step[0];
            int y = poll[1] + step[1];
            Long hash = (long) x * n + y;
            if (x < 0 || x >= n || y < 0 || y >= n || blockedSet.contains(hash) || setFrom.contains(hash)) {
                continue;
            }
            if (setTo.contains(hash)) {
                return true;
            }
            setFrom.add(hash);
            q.offer(new int[]{x, y});
        }
        return false;
    }

    public boolean isEscapePossible1(int[][] blocked, int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) {
            return true;
        }

        int n = (int) 1e6;
        int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Map<Integer, Set<Integer>> blockedSet = new HashMap<>();
        for (int[] b : blocked) {
            blockedSet.putIfAbsent(b[0], new HashSet<>());
            blockedSet.get(b[0]).add(b[1]);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(source);
        while (q.size() > 0) {
            int[] poll = q.poll();
            for (int[] step : steps) {
                int x = poll[0] + step[0];
                int y = poll[1] + step[1];
                if (x == target[0] && x == target[1]) {
                    return true;
                }
                if (x < 0 || x >= n || y < 0 || y >= n || blockedSet.getOrDefault(x, new HashSet<>()).contains(y)) {
                    continue;
                }
                q.offer(new int[]{x, y});
            }
        }
        return false;
    }
}
