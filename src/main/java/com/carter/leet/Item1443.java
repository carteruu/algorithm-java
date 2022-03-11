package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 子节点与父节点的对应关系 : 如果[3->5],则a[5]=3
        int[] fatherIndex = new int[n];
        // 把边信息进行转换
        for (int[] edge : edges) {
            fatherIndex[edge[1]] = edge[0];
        }
        int count = 0;
        // 从后往前推
        for (int i = fatherIndex.length - 1; i > 0; i--) {
            if (hasApple.get(i)) {
                // 检测到有苹果则 +1 ,并且假装父节点有苹果
                count++;
                hasApple.set(fatherIndex[i], true);
            }
        }
        // 每条边都需要走两边,一去一回
        return count << 1;
    }

    //TODO
    public int minTime2(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] childLists = new List[n];
        int[] parents = new int[n];
        int[] appleNums = new int[n];
        for (int i = 0; i < n; i++) {
            childLists[i] = new ArrayList<>(n);
        }
        for (int[] edge : edges) {
            childLists[edge[0]].add(edge[1]);
            parents[edge[1]] = edge[0];
        }
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                int node = i;
                appleNums[node]++;
                while (node != 0) {
                    node = parents[node];
                    appleNums[node]++;
                }
            }
        }

        return step(childLists, parents, appleNums, 0);
    }

    private int step(List<Integer>[] childLists, int[] parents, int[] appleNums, int idx) {
        if (appleNums[idx] > 0) {
            //当前节点有苹果
            int node = idx;
            appleNums[node]--;
            while (node != 0) {
                node = parents[node];
                appleNums[node]--;
            }
        }
        int count = 0;
        for (int child : childLists[idx]) {
            if (appleNums[child] > 0) {
                count += (step(childLists, parents, appleNums, child) + 2);
            }
        }
        return count;
    }
}
