package com.carter.leet;

public class Item2151 {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        //遍历所有组合
        for (int i = 0; i < (1 << statements.length); i++) {
            if (check(statements, i)) {
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }

    private boolean check(int[][] sta, int mark) {
        //遍历每一个人
        for (int i = 0; i < sta.length; i++) {
            //当前人为好人时,才需要判断他对其他人的看法是否和当前组合自洽
            if ((mark & (1 << i)) > 0) {
                for (int j = 0; j < sta.length; j++) {
                    if (sta[i][j] == 2) {
                        //没有看法
                        continue;
                    }
                    int jState = mark & (1 << j);
                    if ((sta[i][j] == 1 && jState == 0) || (sta[i][j] == 0 && jState > 0)) {
                        //有矛盾,当前组合不满足要求
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int maximumGood1(int[][] statements) {
        int max = 0;
        int all = 1 << statements.length;
        for (int mask = 0; mask < all; mask++) {
            if (maximumGood(mask, statements)) {
                max = Math.max(max, Integer.bitCount(mask));
            }
        }
        return max;
    }

    private boolean maximumGood(int mask, int[][] statements) {
        for (int i = 0; i < statements.length; i++) {
            if ((mask & (1 << i)) > 0) {
                for (int j = 0; j < statements.length; j++) {
                    if (statements[i][j] < 2 && (mask & (1 << j)) > 0 != statements[i][j] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
