package com.carter.leet;

import java.util.Arrays;

public class Item913 {
    static int N = 55;
    static int[][][] f = new int[2 * N * N][N][N];
    int[][] g;
    int n;

    public int catMouseGame(int[][] graph) {
        g = graph;
        n = g.length;
        for (int k = 0; k < 2 * n * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[k][i][j] = -1;
                }
            }
        }
        return dfs(0, 1, 2);
    }

    /**
     * 0:draw / 1:mouse / 2:cat
     *
     * @param k
     * @param a
     * @param b
     * @return
     */
    private int dfs(int k, int a, int b) {
        int ans = f[k][a][b];
        if (a == 0) {
            ans = 1;
        } else if (a == b) {
            ans = 2;
        } else if (k >= 2 * n * n) {
            ans = 0;
        } else if (ans == -1) {
            if (k % 2 == 0) {
                // mouse
                boolean win = false, draw = false;
                for (int ne : g[a]) {
                    int t = dfs(k + 1, ne, b);
                    if (t == 1) {
                        win = true;
                    } else if (t == 0) {
                        draw = true;
                    }
                    if (win) {
                        break;
                    }
                }
                if (win) {
                    ans = 1;
                } else if (draw) {
                    ans = 0;
                } else {
                    ans = 2;
                }
            } else {
                // cat
                boolean win = false, draw = false;
                for (int ne : g[b]) {
                    if (ne == 0) {
                        continue;
                    }
                    int t = dfs(k + 1, a, ne);
                    if (t == 2) {
                        win = true;
                    } else if (t == 0) {
                        draw = true;
                    }
                    if (win) {
                        break;
                    }
                }
                if (win) {
                    ans = 2;
                } else if (draw) {
                    ans = 0;
                } else {
                    ans = 1;
                }
            }
        }
        f[k][a][b] = ans;
        return ans;
    }

    class Solution {
        static final int MOUSE_WIN = 1;
        static final int CAT_WIN = 2;
        static final int DRAW = 0;
        int n;
        int[][] graph;
        int[][][] dp;

        public int catMouseGame(int[][] graph) {
            this.n = graph.length;
            this.graph = graph;
            this.dp = new int[n][n][n * 2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return getResult(1, 2, 0);
        }

        public int getResult(int mouse, int cat, int turns) {
            if (turns == n * 2) {
                return DRAW;
            }
            if (dp[mouse][cat][turns] < 0) {
                if (mouse == 0) {
                    dp[mouse][cat][turns] = MOUSE_WIN;
                } else if (cat == mouse) {
                    dp[mouse][cat][turns] = CAT_WIN;
                } else {
                    getNextResult(mouse, cat, turns);
                }
            }
            return dp[mouse][cat][turns];
        }

        public void getNextResult(int mouse, int cat, int turns) {
            int curMove = turns % 2 == 0 ? mouse : cat;
            int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
            int result = defaultResult;
            int[] nextNodes = graph[curMove];
            for (int next : nextNodes) {
                if (curMove == cat && next == 0) {
                    continue;
                }
                int nextMouse = curMove == mouse ? next : mouse;
                int nextCat = curMove == cat ? next : cat;
                int nextResult = getResult(nextMouse, nextCat, turns + 1);
                if (nextResult != defaultResult) {
                    result = nextResult;
                    if (result != DRAW) {
                        break;
                    }
                }
            }
            dp[mouse][cat][turns] = result;
        }
    }
}
