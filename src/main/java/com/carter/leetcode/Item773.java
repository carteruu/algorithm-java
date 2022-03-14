package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Item773 {
    private int[] swap = new int[]{1, -1};

    public int slidingPuzzle(int[][] board) {
        if (find(board)) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(str(board));
        Queue<Object[]> queue = new ArrayDeque<>();
        int rs = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    queue.offer(new Object[]{board, i, j});
                }
            }
        }

        //广度优先搜索
        while (queue.size() > 0) {
            int size = queue.size();
            rs++;
            for (int i = 0; i < size; i++) {
                //弹出一个
                Object[] poll = queue.poll();
                //生成0和上下左右交换位置,判断是否满足条件
                int[][] curBoard = (int[][]) poll[0];
                int rowIdx = (int) poll[1];
                int columnIdx = (int) poll[2];
                for (int s : swap) {
                    //上下交换
                    int rowSwap = rowIdx + s;
                    if (rowSwap >= 0 && rowSwap <= 1) {
                        int[][] n = copy(curBoard);
                        n[rowIdx][columnIdx] = n[rowSwap][columnIdx];
                        n[rowSwap][columnIdx] = 0;
                        Integer str = str(n);
                        if (!set.contains(str)) {
                            if (find(n)) {
                                return rs;
                            }
                            set.add(str);
                            queue.offer(new Object[]{n, rowSwap, columnIdx});
                        }
                    }
                    //左右交换
                    int columnSwap = columnIdx + s;
                    if (columnSwap >= 0 && columnSwap <= 2) {
                        int[][] n = copy(curBoard);
                        n[rowIdx][columnIdx] = n[rowIdx][columnSwap];
                        n[rowIdx][columnSwap] = 0;
                        Integer str = str(n);
                        if (!set.contains(str)) {
                            if (find(n)) {
                                return rs;
                            }
                            set.add(str);
                            queue.offer(new Object[]{n, rowIdx, columnSwap});
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int[][] copy(int[][] curBoard) {
        int[][] n = new int[2][3];
        for (int j = 0; j < curBoard.length; j++) {
            System.arraycopy(curBoard[j], 0, n[j], 0, curBoard[j].length);
        }
        return n;
    }

    private Integer str(int[][] board) {
        int rs = 0;
        for (int[] a : board) {
            for (int i : a) {
                rs += rs * 10 + i;
            }
        }
        return rs;
    }

    private int[][] resBoard = new int[][]{{1, 2, 3}, {4, 5, 0}};

    private boolean find(int[][] board) {
        for (int i = 0; i < resBoard.length; i++) {
            for (int j = 0; j < resBoard[0].length; j++) {
                if (resBoard[i][j] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
