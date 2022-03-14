package com.carter.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Item1001 {
    /**
     * 自身及8个相邻方向
     */
    private final int[][] steps = new int[][]{{0, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //行被照亮的次数
        Map<Integer, Integer> rows = new HashMap<>(lamps.length);
        //列被照亮的次数
        Map<Integer, Integer> cols = new HashMap<>(lamps.length);
        //对角线被照亮的次数,斜率为1,row=col+c -> c=row-col,这里只需要保存c
        Map<Integer, Integer> diagonal1 = new HashMap<>(lamps.length);
        //对角线被照亮的次数,斜率为-1,row=-col+c -> c=row+col
        Map<Integer, Integer> diagonal2 = new HashMap<>(lamps.length);
        //灯所在坐标的哈希,方便后面快速判断某个坐标是否有灯
        Set<Long> lampSet = new HashSet<>(lamps.length);
        for (int[] lamp : lamps) {
            //重复点亮的灯,只计算一次.用long的高32位存纵坐标,低32位存横坐标
            long hash = ((long) lamp[0]) << 32 | lamp[1];
            if (!lampSet.contains(hash)) {
                rows.put(lamp[0], rows.getOrDefault(lamp[0], 0) + 1);
                cols.put(lamp[1], cols.getOrDefault(lamp[1], 0) + 1);
                int c1 = lamp[0] - lamp[1];
                diagonal1.put(c1, diagonal1.getOrDefault(c1, 0) + 1);
                int c2 = lamp[0] + lamp[1];
                diagonal2.put(c2, diagonal2.getOrDefault(c2, 0) + 1);
                lampSet.add(hash);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            //判断查询坐标所在的行,列和对角线是否被点亮.
            if (rows.getOrDefault(query[0], 0) > 0 ||
                    cols.getOrDefault(query[1], 0) > 0 ||
                    diagonal1.getOrDefault(query[0] - query[1], 0) > 0 ||
                    diagonal2.getOrDefault(query[0] + query[1], 0) > 0) {
                ans[i] = 1;
                //关灯,判断9个位置是否存在灯,存在则关闭,照亮次数-1
                for (int[] step : steps) {
                    int row = query[0] + step[0];
                    int col = query[1] + step[1];
                    long hash = ((long) row) << 32 | col;
                    if (row >= 0 && row < n && col >= 0 && col < n && lampSet.contains(hash)) {
                        rows.put(row, rows.get(row) - 1);
                        cols.put(col, cols.get(col) - 1);
                        diagonal1.put(row - col, diagonal1.getOrDefault(row - col, 0) - 1);
                        diagonal2.put(row + col, diagonal2.getOrDefault(row + col, 0) - 1);
                        lampSet.remove(hash);
                    }
                }
            }
        }
        return ans;
    }
}
