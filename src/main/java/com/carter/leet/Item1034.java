package com.carter.leet;

import com.carter.UnionFind;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item1034 {
    private final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        dfs(grid, seen, row, col, grid[row][col], color);
        return grid;
    }

    /**
     * @param grid
     * @param r 当前网格块的横坐标
     * @param c 当前网格块的纵坐标
     * @param colorSame 连通分量的颜色
     * @param colorChange 连通分量边界需要设置的颜色
     * @return 是否超出连通分量的边界
     */
    private boolean dfs(int[][] grid, boolean[][] seen, int r, int c, int colorSame, int colorChange) {
        //是否超出网格边界,是则为超出连通分量,结束递归
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return true;
        }
        //判断是否访问过
        if (seen[r][c]) {
            //因为只访问连通分量内的网格块,所以所有访问过的网格块都没有超出连通分量,返回false
            return false;
        }
        //判断是否与grid[row][col]的颜色不同,是则为超出连通分量,结束递归
        if (grid[r][c] != colorSame) {
            return true;
        }
        //设置为访问过,避免重复访问
        seen[r][c] = true;
        //遍历当前网格块四周,如果存在超出连通分量,则当前网格块为连通分量的边界
        for (int[] step : steps) {
            if (dfs(grid, seen, r + step[0], c + step[1], colorSame, colorChange)) {
                grid[r][c] = colorChange;
            }
        }
        return false;
    }

    public int[][] colorBorder2(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int colorSame = grid[row][col];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>(m * n);
        //加入初始网格块
        queue.offer(new int[]{row, col});
        while (queue.size() > 0) {
            int[] poll = queue.poll();
            if (poll[0] == 0 || poll[0] == m - 1 || poll[1] == 0 || poll[1] == n - 1) {
                //处于网格边界,改变颜色
                grid[poll[0]][poll[1]] = color;
            }
            //遍历四周,将未访问且与grid[row][col]颜色相同的网格块加入队列,
            //并判断当前访问的网格块是否与相邻的网格块颜色不同，是则为连通分量的边界，需要改变颜色
            for (int[] step : steps) {
                int r = poll[0] + step[0];
                int c = poll[1] + step[1];
                if (r < 0 || r >= m || c < 0 || c >= n || seen[r][c]) {
                    //超出网格边界或已经访问过
                    continue;
                }
                if (grid[r][c] == colorSame) {
                    //相邻且相同颜色
                    queue.offer(new int[]{r, c});
                } else {
                    //改变颜色
                    grid[poll[0]][poll[1]] = color;
                }
            }
            seen[poll[0]][poll[1]] = true;
        }
        return grid;
    }

    public int[][] colorBorder1(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        //遍历每一个网格块,连接与其相邻且相同颜色的网格块(只需要处理左边和下边的网格块)
        //使用二维转一维的简化技巧
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = i * n + j;
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    //左边
                    uf.union(cell, cell + 1);
                }
                if (i + 1 < m && grid[i][j] == grid[i + 1][j]) {
                    //下边
                    uf.union(cell, cell + n);
                }
            }
        }
        //遍历每一个网格块,判断是否与grid[row][col]相连,是则判断是否处于连通分量的边界,是则修改颜色
        int target = row * n + col;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int node = i * n + j;
                if (uf.connected(node, target)) {
                    //与grid[row][col]相连
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        //处于网格边界
                        grid[i][j] = color;
                        continue;
                    }
                    for (int[] step : steps) {
                        if (!uf.connected(node, node + step[0] * n + step[1])) {
                            //与四周的网格块不相连
                            grid[i][j] = color;
                            break;
                        }
                    }
                }
            }
        }
        return grid;
    }
}
