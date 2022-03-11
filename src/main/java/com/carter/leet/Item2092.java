package com.carter.leet;


import java.util.*;

public class Item2092 {
    public List<Integer> findAllPeople2(int n, int[][] meetings, int firstPerson) {
        //按时间排序
        Arrays.sort(meetings, Comparator.comparing(o -> o[2]));
        //已经找到秘密的专家
        boolean[] secret = new boolean[n];
        secret[0] = true;
        secret[firstPerson] = true;
        for (int i = 0; i < meetings.length; ) {
            //按开会时间分批处理
            int time = meetings[i][2];
            //邻接表
            Map<Integer, List<Integer>> adjs = new HashMap<>();
            while (i < meetings.length && meetings[i][2] == time) {
                adjs.putIfAbsent(meetings[i][0], new ArrayList<>());
                adjs.putIfAbsent(meetings[i][1], new ArrayList<>());
                adjs.get(meetings[i][0]).add(meetings[i][1]);
                adjs.get(meetings[i][1]).add(meetings[i][0]);
                i++;
            }
            //广度优先搜索的队列
            Queue<Integer> q = new ArrayDeque<>(n);
            //加入已经知道秘密的专家
            for (Integer start : adjs.keySet()) {
                if (secret[start]) {
                    q.add(start);
                }
            }
            while (q.size() > 0) {
                Integer poll = q.poll();
                for (Integer adj : adjs.get(poll)) {
                    if (!secret[adj]) {
                        q.add(adj);
                        secret[adj] = true;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparing(o -> o[2]));
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        for (int i = 0; i < meetings.length; ) {
            //按开会时间分批处理
            int j = i;
            int time = meetings[i][2];
            //开会的两个专家连通
            while (i < meetings.length && meetings[i][2] == time) {
                uf.union(meetings[i][0], meetings[i][1]);
                i++;
            }
            //同一时间开会的所有专家连通后,如果同一个会议中的某一位专家不和0号专家连通,则取消连通
            for (int k = j; k < i; k++) {
                int p1 = meetings[k][0];
                if (!uf.connected(0, p1)) {
                    int p2 = meetings[k][1];
                    uf.parents[p1] = p1;
                    uf.parents[p2] = p2;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.connected(0, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAllPeople1(int n, int[][] meetings, int firstPerson) {
        //邻接表
        List<int[]>[] adjs = new List[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] m : meetings) {
            adjs[m[0]].add(new int[]{m[1], m[2]});
            adjs[m[1]].add(new int[]{m[0], m[2]});
        }
        //队列:[专家,开会时间]
        Queue<int[]> q = new ArrayDeque<>();
        //按题意把初始值放进去
        q.add(new int[]{0, 0});
        q.add(new int[]{firstPerson, 0});
        //专家 -> 最早知道时间
        int[] map = new int[n];
        Arrays.fill(map, Integer.MAX_VALUE);
        while (q.size() > 0) {
            int[] poll = q.poll();
            //判断当前专家,最早知道时间是否提前,如果提前需要更新相关的专家
            if (poll[1] < map[poll[0]]) {
                for (int[] adj : adjs[poll[0]]) {
                    //开会时间,早于poll专家知道的时间
                    //该专家不知道秘密或者知道的时间提前了
                    if (adj[1] >= poll[1] && poll[1] < map[adj[0]]) {
                        q.add(adj);
                    }
                }
                map[poll[0]] = poll[1];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static class UnionFind {
        /**
         * 根节点的父节点是自身
         */
        private final int[] parents;
        /**
         * 每棵树的节点数
         */
        private final int[] sizes;

        public int getCnt() {
            return cnt;
        }

        /**
         * 连通分量
         */
        private int cnt;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];
            this.cnt = n;
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
                this.sizes[i] = 1;
            }
        }

        /**
         * 连接两个节点
         *
         * @param node1
         * @param node2
         * @return
         */
        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if (parent1 == parent2) {
                return false;
            }
            if (sizes[parent1] < sizes[parent2]) {
                //树2比树1的节点多,树2的根节点作为根.增加树2的节点数
                parents[parent1] = parent2;
                sizes[parent2] += sizes[parent1];
            } else {
                //树1比树2的节点多,树1的根节点作为根.增加树1的节点数
                parents[parent2] = parent1;
                sizes[parent1] += sizes[parent2];
            }
            this.cnt--;
            return true;
        }

        /**
         * 两个节点是否相连
         *
         * @param node1
         * @param node2
         * @return
         */
        public boolean connected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        /**
         * 查找根节点
         *
         * @param node
         * @return
         */
        public int find(int node) {
            while (parents[node] != parents[parents[node]]) {
                //如果当前节点的父节点不是根节点,将当前节点移到其祖父节点,直到当前节点的父节点是根节点
                sizes[parents[node]] -= sizes[node];
                sizes[parents[parents[node]]] += sizes[node];
                parents[node] = parents[parents[node]];
            }
            return parents[node];
        }
    }
}
