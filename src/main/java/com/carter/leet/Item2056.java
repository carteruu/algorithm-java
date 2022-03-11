package com.carter.leet;

/**
 * TODO 不对
 */
public class Item2056 {
    private int[][][] b = new int[8][8][];
    private int ans = 0;
    private int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int countCombinations(String[] pieces, int[][] positions) {
        for (int i = 0; i < pieces.length; i++) {
            int row = positions[i][0] - 1;
            int col = positions[i][1] - 1;
            b[row][col] = new int[]{pieces[i].charAt(0), row, col};
        }
        helper(0, pieces, positions);
        return ans;
    }

    private void helper(int idx, String[] pieces, int[][] positions) {
        if (idx == pieces.length) {
            ans++;
            return;
        }
        helper(idx + 1, pieces, positions);
        int row = positions[idx][0] - 1;
        int col = positions[idx][1] - 1;
        int[] p = b[row][col];
        b[row][col] = null;
        if ("rook".equals(pieces[idx])) {
            for (int i = 0; i < 4; i++) {
                int[] step = steps[i];
                int row1, col1;
                for (int mul = 1; ; mul++) {
                    row1 = row + mul * step[0];
                    col1 = col + mul * step[1];
                    if (row1 < 0 || row1 > 7 || col1 < 0 || col1 > 7) {
                        //不在棋盘范围
                        break;
                    }
                    if (b[row1][col1] != null) {
                        //已存在棋子
                        boolean no = b[row1][col1][0] != 'q' && b[row1][col1][0] != 'r';
                        if (no || (row != b[row1][col1][1] && col != b[row1][col1][2])) {
                            break;
                        }
                    }
                    b[row1][col1] = p;
                    helper(idx + 1, pieces, positions);
                    b[row1][col1] = null;
                }
            }
        }
        if ("bishop".equals(pieces[idx])) {
            for (int i = 4; i < 8; i++) {
                int[] step = steps[i];
                int row1, col1;
                for (int mul = 1; ; mul++) {
                    row1 = row + mul * step[0];
                    col1 = col + mul * step[1];
                    if (row1 < 0 || row1 > 7 || col1 < 0 || col1 > 7) {
                        //不在棋盘范围
                        break;
                    }
                    if (b[row1][col1] != null) {
                        //已存在棋子
                        boolean no = b[row1][col1][0] != 'q';
                        if (no || Math.abs(row - b[row1][col1][1]) != Math.abs(col - b[row1][col1][2])) {
                            break;
                        }
                    }
                    b[row1][col1] = p;
                    helper(idx + 1, pieces, positions);
                    b[row1][col1] = null;
                }
            }
        }
        if ("queen".equals(pieces[idx])) {
            for (int i = 0; i < 8; i++) {
                int[] step = steps[i];
                int row1, col1;
                for (int mul = 1; ; mul++) {
                    row1 = row + mul * step[0];
                    col1 = col + mul * step[1];
                    if (row1 < 0 || row1 > 7 || col1 < 0 || col1 > 7) {
                        //不在棋盘范围,或者已存在棋子
                        break;
                    }
                    if (b[row1][col1] != null) {
                        //已存在棋子
                        continue;
                    }
                    b[row1][col1] = p;
                    helper(idx + 1, pieces, positions);
                    b[row1][col1] = null;
                }
            }
        }
        b[row][col] = p;
    }

    class Solution {
        public int countCombinations(String[] pieces, int[][] positions) {
            int n = pieces.length;
            int[][] dir = new int[n][];
            for (int i = 0; i < n; i++) {
                if (pieces[i].equals("queen")) {
                    dir[i] = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
                } else if (pieces[i].equals("bishop")) {
                    dir[i] = new int[]{4, 5, 6, 7};
                } else {
                    dir[i] = new int[]{0, 1, 2, 3};
                }
            }
            solve(dir, new int[n], new int[n], positions, 0);
            return res;
        }

        int[][] v = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int res = 0;

        public boolean check(int[][] positions) {
            for (int i = 0; i < positions.length; i++) {
                for (int j = 0; j < positions.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (positions[i][0] == positions[j][0] && positions[i][1] == positions[j][1]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void solve(int[][] dir, int[] s, int[] step, int[][] positions, int idx) {
            if (idx == positions.length) {
                int t = 0;
                int[][] cur = new int[positions.length][2];
                for (int i = 0; i < cur.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        cur[i][j] = positions[i][j];
                    }
                }
                boolean f = true;
                while (f) {
                    f = false;
                    for (int i = 0; i < cur.length; i++) {
                        if (t < step[i]) {
                            cur[i][0] += v[s[i]][0];
                            cur[i][1] += v[s[i]][1];
                            f = true;
                        }
                    }
                    if (!check(cur)) {
                        return;
                    }
                    t++;
                }
                res++;
                return;
            }
            solve(dir, s, step, positions, idx + 1);
            for (int i = 0; i < dir[idx].length; i++) {
                int j = dir[idx][i];
                for (int num = 1; num < 8; num++) {
                    int x = positions[idx][0] + v[j][0] * num, y = positions[idx][1] + v[j][1] * num;
                    if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
                        s[idx] = j;
                        step[idx] = num;
                        solve(dir, s, step, positions, idx + 1);
                        s[idx] = 0;
                        step[idx] = 0;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
