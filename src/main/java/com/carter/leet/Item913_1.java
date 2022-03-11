package com.carter.leet;

import java.util.Arrays;

public class Item913_1 {
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int DRAW = 0;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        //记忆化搜索,未遍历过为-1
        int[][][] dp = new int[n][n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(graph, dp, 1, 2, 0, 2 * graph.length);
    }

    /**
     * @param graph 图
     * @param dp    记忆数组
     * @param mouse 老鼠的位置
     * @param cat   猫的位置
     * @param step  已走的步骤数
     * @param end   结束的步骤数,当猫和老鼠把所有位置都走一遍时,必定走了重复的节点,所以平局.即节点数*2
     * @return
     */
    private int dfs(int[][] graph, int[][][] dp, int mouse, int cat, int step, int end) {
        if (step == end) {
            //平局
            return DRAW;
        }
        if (mouse == 0) {
            //老鼠到洞里,老鼠赢
            return MOUSE_WIN;
        }
        if (mouse == cat) {
            //猫抓到老鼠,猫赢
            return CAT_WIN;
        }
        if (dp[mouse][cat][step] >= 0) {
            //已经计算过了,直接返回
            return dp[mouse][cat][step];
        }
        int rt;
        if (step % 2 == 0) {
            //老鼠的回合,默认是猫赢,除非能走到洞里或能走到平局的情况
            rt = CAT_WIN;
            for (int next : graph[mouse]) {
                int dfs = dfs(graph, dp, next, cat, step + 1, end);
                if (dfs == MOUSE_WIN) {
                    //老鼠赢,直接走这个位置,结束
                    rt = MOUSE_WIN;
                    break;
                } else if (dfs == DRAW) {
                    //平局,需要继续计算其他情况
                    rt = DRAW;
                }
            }
        } else {
            //猫的回合,默认是鼠赢,除非能抓到老鼠或能走到平局的情况
            rt = MOUSE_WIN;
            for (int next : graph[cat]) {
                if (next == 0) {
                    //猫不能走0
                    continue;
                }
                int dfs = dfs(graph, dp, mouse, next, step + 1, end);
                if (dfs == CAT_WIN) {
                    //猫赢,直接走这个位置,结束
                    rt = CAT_WIN;
                    break;
                } else if (dfs == DRAW) {
                    //平局,需要继续计算其他情况
                    rt = DRAW;
                }
            }
        }
        //记住当前状态的结果
        dp[mouse][cat][step] = rt;
        return rt;
    }
}
