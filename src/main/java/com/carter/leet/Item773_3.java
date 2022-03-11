package com.carter.leet;

import java.util.*;

public class Item773_3 {
    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] target = new int[][]{{1, 2, 3}, {4, 5, 0}};
        int targetNum = 123450;
        int[] start = new int[6];
        int startNum = 0;
        int zeroIdx = 0;
        boolean find = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start[i * 3 + j] = board[i][j];
                startNum = startNum * 10 + board[i][j];
                if (board[i][j] != target[i][j]) {
                    find = false;
                }
                if (board[i][j] == 0) {
                    zeroIdx = i * n + j;
                }
            }
        }
        if (find) {
            return 0;
        }
        int step = 0;
        Queue<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{start, zeroIdx});
        Set<Integer> seen = new HashSet<>();
        seen.add(startNum);
        while (queue.size() > 0) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object[] poll = queue.poll();
                List<Object[]> ns = new ArrayList<>();
                swapAbove(ns, poll);
                swapBelow(ns, poll);
                swapLeft(ns, poll);
                swapRight(ns, poll);
                for (Object[] swap : ns) {
                    int key = 0;
                    int[] nb = (int[]) swap[0];
                    for (int num : nb) {
                        key = key * 10 + num;
                    }
                    if (key == targetNum) {
                        return step;
                    }
                    if (seen.contains(key)) {
                        continue;
                    }
                    seen.add(key);
                    queue.offer(swap);
                }
            }
        }
        return -1;
    }

    private void swapAbove(List<Object[]> ns, Object[] poll) {
        int zeroPos = (int) poll[1];
        if (zeroPos != 3 && zeroPos != 4 && zeroPos != 5) {
            return;
        }
        int[] b = (int[]) poll[0];
        int next[] = new int[b.length];
        System.arraycopy(b, 0, next, 0, b.length);
        next[zeroPos] = next[zeroPos - 3];
        next[zeroPos - 3] = 0;
        ns.add(new Object[]{next, zeroPos - 3});
    }

    private void swapBelow(List<Object[]> ns, Object[] poll) {
        int zeroPos = (int) poll[1];
        if (zeroPos != 0 && zeroPos != 1 && zeroPos != 2) {
            return;
        }
        int[] b = (int[]) poll[0];
        int next[] = new int[b.length];
        System.arraycopy(b, 0, next, 0, b.length);
        next[zeroPos] = next[zeroPos + 3];
        next[zeroPos + 3] = 0;
        ns.add(new Object[]{next, zeroPos + 3});
    }

    private void swapLeft(List<Object[]> ns, Object[] poll) {
        int zeroPos = (int) poll[1];
        if (zeroPos != 1 && zeroPos != 2 && zeroPos != 4 && zeroPos != 5) {
            return;
        }
        int[] b = (int[]) poll[0];
        int next[] = new int[b.length];
        System.arraycopy(b, 0, next, 0, b.length);
        next[zeroPos] = next[zeroPos - 1];
        next[zeroPos - 1] = 0;
        ns.add(new Object[]{next, zeroPos - 1});
    }

    private void swapRight(List<Object[]> ns, Object[] poll) {
        int zeroPos = (int) poll[1];
        if (zeroPos != 0 && zeroPos != 1 && zeroPos != 3 && zeroPos != 4) {
            return;
        }
        int[] b = (int[]) poll[0];
        int next[] = new int[b.length];
        System.arraycopy(b, 0, next, 0, b.length);
        next[zeroPos] = next[zeroPos + 1];
        next[zeroPos + 1] = 0;
        ns.add(new Object[]{next, zeroPos + 1});
    }
}
