package com.carter.leet;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item1162 {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //距离
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //陆地,加入队列,相当于将所有陆地看成是一个节点,从这个节点出发,找到最远的海洋
                    queue.offer(new int[]{i, j});
                } else {
                    //海洋,距离陆地的距离未确定
                    distance[i][j] = -1;
                }
            }
        }
        if (queue.size() == m * n || queue.isEmpty()) {
            //全是陆地或全是海
            return -1;
        }
        int d = 0;
        //曼哈顿距离,四边相邻为1,对角线相邻为2.所以这里遍历四边相邻的单元格
        int[][] steps = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (queue.size() > 0) {
            d++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] step : steps) {
                    int[] next = new int[]{poll[0] + step[0], poll[1] + step[1]};
                    //超出范围,跳过
                    //距离陆地的距离已确定,跳过
                    if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n || distance[next[0]][next[1]] != -1) {
                        continue;
                    }
                    //广度优先搜索,且只赋值一次,不需要判断距离大小,直接赋值
                    distance[next[0]][next[1]] = d;
                    queue.offer(next);
                }
            }
        }
        return d - 1;
    }
}

//class Solution {
//    public int maxDistance(int[][] grid) {
//        final int INF = 1000000;
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        int n = grid.length;
//        int[][] d = new int[n][n];
//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(status -> status[0]));
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                d[i][j] = INF;
//            }
//        }
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 1) {
//                    d[i][j] = 0;
//                    queue.offer(new int[]{0, i, j});
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int[] f = queue.poll();
//            for (int i = 0; i < 4; ++i) {
//                int nx = f[1] + dx[i], ny = f[2] + dy[i];
//                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
//                    continue;
//                }
//                if (f[0] + 1 < d[nx][ny]) {
//                    d[nx][ny] = f[0] + 1;
//                    queue.offer(new int[]{d[nx][ny], nx, ny});
//                }
//            }
//        }
//
//        int ans = -1;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 0) {
//                    ans = Math.max(ans, d[i][j]);
//                }
//            }
//        }
//
//        return ans == INF ? -1 : ans;
//    }
//}
//
//class Solution1 {
//    public int maxDistance(int[][] grid) {
//        final int INF = 1000000;
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        int n = grid.length;
//        int[][] d = new int[n][n];
//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(status -> status[0]));
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                d[i][j] = INF;
//            }
//        }
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 1) {
//                    d[i][j] = 0;
//                    queue.offer(new int[]{0, i, j});
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int[] f = queue.poll();
//            for (int i = 0; i < 4; ++i) {
//                int nx = f[1] + dx[i], ny = f[2] + dy[i];
//                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
//                    continue;
//                }
//                if (f[0] + 1 < d[nx][ny]) {
//                    d[nx][ny] = f[0] + 1;
//                    queue.offer(new int[]{d[nx][ny], nx, ny});
//                }
//            }
//        }
//
//        int ans = -1;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 0) {
//                    ans = Math.max(ans, d[i][j]);
//                }
//            }
//        }
//
//        return ans == INF ? -1 : ans;
//    }
//}
class Solution3 {
    public int maxDistance(int[][] grid) {
        final int INF = 1000000;
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = grid[i][j] == 1 ? 0 : INF;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }

        if (ans == INF) {
            return -1;
        } else {
            return ans;
        }
    }
}