package com.carter.leet;

import java.util.*;

public class Item2097 {
    public int[][] validArrangement(int[][] pairs) {
        //邻接表,有向
        Map<Integer, List<Integer>> edges = new HashMap<>();
        //入度
        Map<Integer, Integer> inDeg = new HashMap<>();
        //出度
        Map<Integer, Integer> outDeg = new HashMap<>();
        for (int[] pair : pairs) {
            edges.putIfAbsent(pair[0], new ArrayList<>());
            edges.get(pair[0]).add(pair[1]);

            inDeg.put(pair[1], inDeg.getOrDefault(pair[1], 0) + 1);
            outDeg.put(pair[0], outDeg.getOrDefault(pair[0], 0) + 1);
        }
        //起始节点:出度比入度大1,没有找到的话,默认使用第一个节点
        int start = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : outDeg.entrySet()) {
            if (entry.getValue() - inDeg.getOrDefault(entry.getKey(), 0) == 1) {
                start = entry.getKey();
                break;
            }
        }
        //Hierholzer算法
        List<int[]> list = new ArrayList<>(pairs.length);
        dfs(edges, list, start);
        int[][] ans = new int[pairs.length][];
        for (int i = 0; i < pairs.length; i++) {
            ans[pairs.length - 1 - i] = list.get(i);
        }
        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> edges, List<int[]> list, int start) {
        while (edges.getOrDefault(start, new ArrayList<>()).size() > 0) {
            List<Integer> edge = edges.get(start);
            int end = edge.remove(edge.size() - 1);
            dfs(edges, list, end);
            list.add(new int[]{start, end});
        }
    }

    class Solution {
        public int[][] validArrangement(int[][] pairs) {
            ArrayList<Integer> res = EulerianPath(pairs);
            //System.out.println(res);
            Collections.reverse(res);
            int n = pairs.length;
            int[][] ans = new int[n][2];
            for (int i = 0; i < n; i++) {
                ans[i] = new int[]{res.get(i), res.get(i + 1)};
            }
            return ans;
        }

        // https://algs4.cs.princeton.edu/41graph/EulerianPath.java
        public ArrayList<Integer> EulerianPath(int[][] pairs) {

            // find vertex from which to start potential Eulerian path:
            // a vertex v with odd degree(v) if it exits;
            // otherwise a vertex with degree(v) > 0
            int oddDegreeVertices = 0;
            HashMap<Integer, Integer> inDeg = new HashMap(),
                    outDeg = new HashMap();
            HashMap<Integer, ArrayDeque<Integer>> neigh = new HashMap();
            for (int[] pair : pairs) {
                outDeg.put(pair[0], outDeg.getOrDefault(pair[0], 0) + 1);
                inDeg.put(pair[1], inDeg.getOrDefault(pair[1], 0) + 1);
                ArrayDeque<Integer> tmp = neigh.getOrDefault(pair[0], new ArrayDeque<Integer>());
                tmp.add(pair[1]);
                neigh.putIfAbsent(pair[0], tmp);
            }
            int s = -1;
            for (int i : outDeg.keySet()) {
                if (outDeg.get(i) - inDeg.getOrDefault(i, 0) == 1) {
                    s = i;
                }
            }
            if (s == -1) {
                s = pairs[0][0];
            }
/*
        // graph can't have an Eulerian path
        // (this condition is needed for correctness)
        if (oddDegreeVertices > 2) return;

        // special case for graph with zero edges (has a degenerate Eulerian path)
        if (s == -1) s = 0;

        // create local view of adjacency lists, to iterate one vertex at a time
        // the helper Edge data type is used to avoid exploring both copies of an edge v-w



        Queue<Edge>[] adj = (Queue<Edge>[]) new Queue[G.V()];
        for (int v = 0; v < G.V(); v++)
            adj[v] = new Queue<Edge>();

        for (int v = 0; v < G.V(); v++) {
            int selfLoops = 0;
            for (int w : G.adj(v)) {
                // careful with self loops
                if (v == w) {
                    if (selfLoops % 2 == 0) {
                        Edge e = new Edge(v, w);
                        adj[v].enqueue(e);
                        adj[w].enqueue(e);
                    }
                    selfLoops++;
                }
                else if (v < w) {
                    Edge e = new Edge(v, w);
                    adj[v].enqueue(e);
                    adj[w].enqueue(e);
                }
            }
        }*/

            // initialize stack with any non-isolated vertex
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(s);

            // greedily search through edges in iterative DFS style
            ArrayList<Integer> path = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                int v = stack.pop();
                //System.out.println(v + " " + neigh.get(v));
                while (neigh.get(v) != null && !neigh.get(v).isEmpty()) {
                    int u = neigh.get(v).pollFirst();
                    stack.push(v);
                    v = u;
                    //System.out.println(v + " " + neigh.get(v));
                }
                // push vertex with no more leaving edges to path
                path.add(v);
            }
            return path;
        }
    }


}
