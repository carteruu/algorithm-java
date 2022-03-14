package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int end = n * n;
        Queue<Integer> queue = new ArrayDeque<>(end);
        queue.offer(1);
        boolean[] seen = new boolean[end + 1];
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (poll == end) {
                    //到终点了,返回结果
                    return step;
                }
                for (int j = 6; j >= 1; j--) {
                    int next = poll + j;
                    //超出范围,或已访问过,跳过
                    if (next > n * n || seen[next]) {
                        continue;
                    }
                    seen[next] = true;
                    //从底往上数的行数
                    int row = (next - 1) / n;
                    //若从底往上的行数为奇数时,列数是从右往左数,需要处理列下标
                    int col = (next - 1) % n;
                    if ((row & 1) == 1) {
                        col = n - 1 - col;
                    }
                    //实际行下标
                    row = n - 1 - row;
                    //是否需要跳转.
                    next = board[row][col] == -1 ? next : board[row][col];
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            boolean[] seen = new boolean[n * n + 1];
            int step = 0;
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int poll = queue.poll();
                    if (poll == n * n) {
                        return step;
                    }
                    for (int j = 1; j <= 6; j++) {
                        int next = poll + j;
                        if (next > n * n || seen[next]) {
                            continue;
                        }
                        seen[next] = true;

                        int row = (next - 1) / n;
                        int col = (next - 1) % n;
                        if ((row & 1) == 1) {
                            //奇数行为倒数
                            col = n - 1 - col;
                        }
                        //行为倒数
                        row = n - 1 - row;
                        next = board[row][col] == -1 ? next : board[row][col];
                        queue.offer(next);
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
