package com.carter.leetcode;

import java.util.*;

public class Item773_2 {
    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int target = 123450;
        int start = 0;
        int zeroIdx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start = start * 10 + board[i][j];
                if (board[i][j] == 0) {
                    zeroIdx = i * n + j;
                }
            }
        }
        if (start == target) {
            return 0;
        }
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, zeroIdx});
        Set<Integer> seen = new HashSet<>();
        seen.add(start);
        while (queue.size() > 0) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                List<int[]> ns = new ArrayList<>();
                swapAbove(ns, poll[0], poll[1]);
                swapBelow(ns, poll[0], poll[1]);
                swapLeft(ns, poll[0], poll[1]);
                swapRight(ns, poll[0], poll[1]);
                for (int[] swap : ns) {
                    if (swap[0] == target) {
                        return step;
                    }
                    if (seen.contains(swap[0])) {
                        continue;
                    }
                    seen.add(swap[0]);
                    queue.offer(swap);
                }
            }
        }
        return -1;
    }

    private void swapAbove(List<int[]> ns, int num, int zeroPos) {
        if (zeroPos != 3 && zeroPos != 4 && zeroPos != 5) {
            return;
        }
        int pow = (int) Math.pow(10, 5 - (zeroPos - 3));
        int p = num / pow % 10;
        ns.add(new int[]{num - p * pow + p * (int) Math.pow(10, 5 - zeroPos), zeroPos - 3});
    }

    private void swapBelow(List<int[]> ns, int num, int zeroPos) {
        if (zeroPos != 0 && zeroPos != 1 && zeroPos != 2) {
            return;
        }
        int pow = (int) Math.pow(10, 5 - (zeroPos + 3));
        int p = num / pow % 10;
        ns.add(new int[]{num - p * pow + p * (int) Math.pow(10, 5 - zeroPos), zeroPos + 3});
    }

    private void swapLeft(List<int[]> ns, int num, int zeroPos) {
        if (zeroPos != 1 && zeroPos != 2 && zeroPos != 4 && zeroPos != 5) {
            return;
        }
        int pow = (int) Math.pow(10, 5 - (zeroPos - 1));
        int p = num / pow % 10;
        ns.add(new int[]{num - p * pow + p * (int) Math.pow(10, 5 - zeroPos), zeroPos - 1});
    }

    private void swapRight(List<int[]> ns, int num, int zeroPos) {
        if (zeroPos != 0 && zeroPos != 1 && zeroPos != 3 && zeroPos != 4) {
            return;
        }
        int pow = (int) Math.pow(10, 5 - (zeroPos + 1));
        int p = num / pow % 10;
        ns.add(new int[]{num - p * pow + p * (int) Math.pow(10, 5 - zeroPos), zeroPos + 1});
    }
}
