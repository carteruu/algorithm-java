package com.carter.leet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Item399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            uf.union(eq.get(0), eq.get(1), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            Parent root1 = uf.findRoot(q.get(0));
            Parent root2 = uf.findRoot(q.get(1));
            if (root1 == null || root2 == null || !Objects.equals(root1.getNode(), root2.getNode())) {
                ans[i] = -1;
            } else {
                ans[i] = root1.getMul() / root2.getMul();
            }
        }
        return ans;
    }

    private static class Parent {
        //父节点
        private final String node;
        //curr = parent * mul
        private final double mul;

        public Parent(String node, double mul) {
            this.node = node;
            this.mul = mul;
        }

        public String getNode() {
            return node;
        }

        public double getMul() {
            return mul;
        }
    }

    private static class UnionFind {
        private Map<String, Parent> parents;

        public UnionFind() {
            parents = new HashMap<>();
        }

        public boolean union(String node1, String node2, double mul) {
            this.initNode(node1);
            this.initNode(node2);
            Parent root1 = findRoot(node1);
            Parent root2 = findRoot(node2);
            if (Objects.equals(root1.getNode(), root2.getNode())) {
                return false;
            }
            parents.put(root1.getNode(), new Parent(root2.getNode(), mul * root2.getMul() / root1.getMul()));
            return true;
        }

        public Parent findRoot(String node) {
            if (!parents.containsKey(node)) {
                return null;
            }
            while (!Objects.equals(parents.get(node).getNode(), parents.get(parents.get(node).getNode()).getNode())) {
                Parent p = parents.get(node);
                Parent pp = parents.get(p.getNode());
                parents.put(node, new Parent(pp.getNode(), p.getMul() * pp.getMul()));
            }
            return parents.get(node);
        }

        private void initNode(String node) {
            if (parents.containsKey(node)) {
                return;
            }
            parents.put(node, new Parent(node, 1));
        }
    }
}
