package com.carter.leet;

import java.util.*;

public class Item773_2_1 {
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
        Queue<int[]> queueStart = new ArrayDeque<>();
        queueStart.offer(new int[]{start, zeroIdx});
        int[] stepStart = new int[543211];
        Arrays.fill(stepStart, -1);
        stepStart[start] = 0;

        Queue<int[]> queueTarget = new ArrayDeque<>();
        queueTarget.offer(new int[]{target, 5});
        int[] stepTarget = new int[543211];
        Arrays.fill(stepTarget, -1);
        stepTarget[target] = 0;

        while (queueStart.size() > 0 && queueTarget.size() > 0) {
            int ans;
            if (queueStart.size() <= queueTarget.size()) {
                ans = bfs(queueStart, stepStart, stepTarget);
            } else {
                ans = bfs(queueTarget, stepTarget, stepStart);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    private Integer bfs(Queue<int[]> queue, int[] curStep, int[] otherStep) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] poll = queue.poll();
            int step = curStep[poll[0]] + 1;
            List<int[]> ns = new ArrayList<>();
            swapAbove(ns, poll[0], poll[1]);
            swapBelow(ns, poll[0], poll[1]);
            swapLeft(ns, poll[0], poll[1]);
            swapRight(ns, poll[0], poll[1]);
            for (int[] next : ns) {
                if (otherStep[next[0]] != -1) {
                    //找到了
                    return step + otherStep[next[0]];
                }
                if (curStep[next[0]] != -1) {
                    //已访问过
                    continue;
                }
                curStep[next[0]] = step;
                queue.offer(next);
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
