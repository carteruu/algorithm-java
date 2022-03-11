package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item2013 {
    class DetectSquares {
        //点的数量:x->y
        private final int[][] xyCnt;
        //点的数量:y->x
        private final int[][] yxCnt;
        private final int n = 1001;

        public DetectSquares() {
            xyCnt = new int[n][n];
            yxCnt = new int[n][n];
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            xyCnt[x][y]++;
            yxCnt[y][x]++;
        }

        public int count(int[] point) {
            int cnt = 0;
            //所有与point在同一个y轴的点
            int x = point[0];
            int y = point[1];
            //所有与point在同一个x轴的点
            for (int ny = 0; ny < xyCnt[x].length; ny++) {
                if (xyCnt[x][ny] == 0) {
                    continue;
                }
                int diff = ny - y;
                if (diff == 0) {
                    //与point重叠的点,不能构成正方形
                    continue;
                }
                int nx = x - diff;
                if (0 <= nx && nx < n) {
                    cnt += xyCnt[x][ny] * yxCnt[y][nx] * yxCnt[ny][nx];
                }
                nx = x + diff;
                if (0 <= nx && nx < n) {
                    cnt += xyCnt[x][ny] * yxCnt[y][nx] * yxCnt[ny][nx];
                }
            }
            return cnt;
        }
    }

    class DetectSquares1 {
        //点的数量:x->y
        private final Map<Integer, Integer>[] xyCnt;
        //点的数量:y->x
        private final Map<Integer, Integer>[] yxCnt;
        private final int n = 1001;

        public DetectSquares1() {
            xyCnt = new Map[n];
            yxCnt = new Map[n];
            for (int i = 0; i < n; i++) {
                xyCnt[i] = new HashMap<>();
                yxCnt[i] = new HashMap<>();
            }
        }

        public void add(int[] point) {
            xyCnt[point[0]].put(point[1], xyCnt[point[0]].getOrDefault(point[1], 0) + 1);
            yxCnt[point[1]].put(point[0], yxCnt[point[1]].getOrDefault(point[0], 0) + 1);
        }

        public int count(int[] point) {
            int cnt = 0;
            int x = point[0];
            int y = point[1];
            //遍历所有与point在同一个x轴的点
            for (Map.Entry<Integer, Integer> yCnt : xyCnt[x].entrySet()) {
                //计算边长
                int sideLen = yCnt.getKey() - y;
                //边长为0,与point重叠的点,不能构成正方形
                if (sideLen == 0) {
                    continue;
                }
                //当前遍历的点的数量 * 与point y轴相同且边长一样 * point对角点的数量
                //注意x轴可以有两个方向
                cnt += yCnt.getValue() * (yxCnt[y].getOrDefault(x - sideLen, 0) * yxCnt[yCnt.getKey()].getOrDefault(x - sideLen, 0)
                        + yxCnt[y].getOrDefault(x + sideLen, 0) * yxCnt[yCnt.getKey()].getOrDefault(x + sideLen, 0));
            }
            return cnt;
        }
    }
}
